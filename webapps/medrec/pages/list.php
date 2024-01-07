<?php
   if(strpos($_SERVER['REQUEST_URI'],"pages")){
        exit(header("Location:../index.php"));
   }
?>

<div id="post">
    <div class="entry">   
	<form name="frm_aturadmin" onsubmit="return validasiIsi();" method="post" action="" enctype=multipart/form-data>
            <?php
                    echo "";
                    $action      = isset($_GET['action'])?$_GET['action']:NULL;
                    $keyword     = validTeks4((isset($_GET['keyword'])?$_GET['keyword']:NULL),25);
                    echo "<input type=hidden name=keyword value=$keyword><input type=hidden name=action value=$action>";
            ?>
            <div style="width: 100%; height: 91%; overflow: auto;">
            <?php

                $keyword= trim(isset($_POST['keyword']))?trim($_POST['keyword']):NULL;   
                $keyword= validTeks4($keyword,25);

                $_sql = "SELECT pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,pasien.nm_ibu from pasien where pasien.no_rkm_medis like '%".$keyword."%' or 
                               pasien.nm_pasien like '%".$keyword."%' or pasien.tgl_lahir like '%".$keyword."%' or pasien.nm_ibu like '%".$keyword."%' order by pasien.no_rkm_medis DESC limit 1000";
                $hasil=bukaquery($_sql);
                $jumlah=mysqli_num_rows($hasil);
                if(mysqli_num_rows($hasil)!=0) {
                    echo "<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0' class='tbl_form'>
                            <tr class='head2'>
                                <td width='5%'><div align='center'>Proses</div></td>
                                <td width='7%'><div align='center'>No.RM</div></td>
                                <td width='15%'><div align='center'>Nama Pasien</div></td>
                                <td width='5%'><div align='center'>J.K.</div></td>
                                <td width='7%'><div align='center'>Tgl.Lahir</div></td>
                                <td width='15%'><div align='center'>Nama Ibu</div></td>
                                <td width='46%'><div align='center'>Riwayat Retensi</div></td>
                            </tr>";
                            while($baris = mysqli_fetch_array($hasil)) {
                                echo "<tr class='isi' title='$baris[0] $baris[1]'>
                                        <td valign='top'>
                                            <center>
                                                <a href=?act=Detail&action=TAMBAH&id=$baris[0]>[Detail]</a>
                                            </center>
                                       </td>
                                        <td valign='top'><a href=?act=Detail&action=TAMBAH&id=$baris[0]>$baris[0]</a></td>
                                        <td valign='top'><a href=?act=Detail&action=TAMBAH&id=$baris[0]>$baris[1]</a></td>
                                        <td valign='top'><a href=?act=Detail&action=TAMBAH&id=$baris[0]>$baris[2]</a></td>
                                        <td valign='top'><a href=?act=Detail&action=TAMBAH&id=$baris[0]>$baris[3]</a></td>
                                        <td valign='top'><a href=?act=Detail&action=TAMBAH&id=$baris[0]>$baris[4]</a></td>
                                        <td  valign='top'>
                                           <table width='100%' border='0' align='center' cellpadding='0' cellspacing='0' class='tbl_form'>";
                                                $_sql2 = "SELECT retensi_pasien.terakhir_daftar,retensi_pasien.tgl_retensi,retensi_pasien.lokasi_pdf from retensi_pasien where retensi_pasien.no_rkm_medis='$baris[0]' ORDER BY retensi_pasien.tgl_retensi ASC ";
                                                $hasil2=bukaquery($_sql2);
                                                if(mysqli_num_rows($hasil2)!=0) {
                                                    echo "<tr class='isi4'>
                                                            <td width='5%'><div align='center'>NO.</div></td>
                                                            <td width='20%'><div align='center'>Terakhir Daftar</div></td>
                                                            <td width='20%'><div align='center'>Tanggal Retensi</div></td>
                                                            <td width='55%'><div align='center'>File Retensi</div></td>
                                                          </tr>";
                                                }
                                                $no=1;
                                                while($baris2 = mysqli_fetch_array($hasil2)) { 
                                                    echo "<tr> 
                                                            <td>$no</td>
                                                            <td>$baris2[0]</td>
                                                            <td>$baris2[1]</td>
                                                            <td><a target=_blank href=../medrec/pages/upload/$baris2[2]>".str_replace("pages/upload/","",$baris2[2])."</a></td>
                                                          </tr>";$no++;
                                                }
                                     echo "</table>
                                        </td>
                                     </tr>";
                            }
                    echo "</table>";           
                } else {echo "Data pasien masih kosong !";}        

                $BtnKeluar=isset($_POST['BtnKeluar'])?$_POST['BtnKeluar']:NULL;
                if (isset($BtnKeluar)) {
                    echo"<meta http-equiv='refresh' content='1;URL=?act=List&action=Keluar'>";
                }

            ?>
            </div>
            <table width="100%" align="center" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr class="head3">					
                    <td width="430px">
                        Keyword : <input name="keyword" class="text" onkeydown="setDefault(this, document.getElementById('MsgIsi1'));" type=text id="TxtIsi1" value="<?php echo $keyword;?>" size="40" maxlength="25" pattern="[a-zA-Z0-9, ./@_]{1,25}" title=" a-zA-Z0-9, ./@_ (Maksimal 25 karakter)" autocomplete="off" autofocus />
                        <input name=BtnCari type=submit class="button" value="&nbsp;&nbsp;Cari&nbsp;&nbsp;" />
                    </td>
                    <td width="140px" >Record : <?php echo $jumlah; ?> </td>
                    <td><input name=BtnKeluar type=submit class="button" value="&nbsp;&nbsp;&nbsp;Keluar&nbsp;&nbsp;&nbsp;" /> </td>
                </tr>
            </table>
	</form>
    </div>
</div>

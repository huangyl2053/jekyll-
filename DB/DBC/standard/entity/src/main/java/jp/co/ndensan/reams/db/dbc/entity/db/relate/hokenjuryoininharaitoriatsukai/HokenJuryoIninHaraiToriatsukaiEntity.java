/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenjuryoininharaitoriatsukai;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;

/**
 * 介護保険受領委任払い取扱事業者登録通知書データEntity
 *
 * @reamsid_L DBC-2120-060 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenJuryoIninHaraiToriatsukaiEntity {

    private YubinNo 送付先郵便番号;
    private AtenaJusho 送付先住所;
    private AtenaMeisho 送付先事業者名称;
    private RString 送付先部署;
    private CustomerBarCodeResult バーコード情報;
    private AtenaMeisho 契約事業者名称;
    private YubinNo 契約事業者郵便番号;
    private AtenaJusho 契約事業者住所;
    private TelNo 契約事業者電話番号;
    private RString 受領委任払い取扱事業所登録番号;
    private FlexibleDate 契約開始年月日;
    private FlexibleDate 契約終了年月日;
    private RString 契約種類;
}

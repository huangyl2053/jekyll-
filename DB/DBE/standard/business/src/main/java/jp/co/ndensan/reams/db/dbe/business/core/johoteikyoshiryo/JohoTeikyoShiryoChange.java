/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.johoteikyoshiryo;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.ShujiiIraiAtenaJoho;
import jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo.JohoTeikyoShiryo;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;

/**
 * 要介護認定結果情報提供票（主治医）のEditorです。
 *
 * @reamsid_L DBE-0220-020 wangkun
 */
public final class JohoTeikyoShiryoChange {

    private JohoTeikyoShiryoChange() {
    }

    /**
     * 介護認定結果情報提供票（主治医）のパラメータを作成します。
     *
     * @param entity 要介護認定結果情報RelateEntity
     * @param 認証者情報 認証者情報
     * @param 通知文 通知文
     * @param 文書番号 文書番号
     * @param 宛先情報 宛先情報
     * @param ページ番号 ページ番号
     * @return 介護認定結果情報提供票（主治医）
     */
    public static JohoTeikyoShiryo createBusiness(YouKaiGoNinTeiKekTesuChiRelateEntity entity,
            NinshoshaSource 認証者情報,
            Map<Integer, RString> 通知文,
            RString 文書番号,
            ShujiiIraiAtenaJoho 宛先情報,
            RString ページ番号) {
        CustomerBarCode barcode = new CustomerBarCode();
        CustomerBarCodeResult result = barcode.convertCustomerBarCode(宛先情報.getTemp_宛名郵便番号().value(), 宛先情報.getTemp_宛名住所().value());
        JohoTeikyoShiryo headItem = new JohoTeikyoShiryo(RDate.getNowDate(),
                DbBusinessConfig.get(ConfigNameDBE.要介護認定結果情報提供票_主治医, RDate.getNowDate(), SubGyomuCode.DBE認定支援),
                通知文.get(1),
                entity.getHihokenshaName(),
                entity.getJusho(),
                new RDate(entity.getNijiHanteiYMD().toString()),
                YokaigoJotaiKubun09.toValue(entity.getNijiHanteiYokaigoJotaiKubunCod()).get名称(),
                new RDate(entity.getNijiHanteiNinteiYukoKaishiYMD().toString()),
                new RDate(entity.getNijiHanteiNinteiYukoShuryoYMD().toString()),
                entity.getShinsakaiIken(),
                認証者情報.denshiKoin,
                認証者情報.koinMojiretsu,
                認証者情報.koinShoryaku,
                認証者情報.ninshoshaShimeiKakeru,
                認証者情報.ninshoshaShimeiKakenai,
                認証者情報.ninshoshaYakushokuMei,
                認証者情報.ninshoshaYakushokuMei1,
                認証者情報.ninshoshaYakushokuMei2,
                文書番号,
                ページ番号,
                result.getCustomerBarCode(),
                宛先情報.getTemp_宛名住所().value(),
                宛先情報.getTemp_宛名機関名(),
                宛先情報.getTemp_宛名氏名().value(),
                ChohyoAtesakiKeisho.toValue(DbBusinessConfig.get(ConfigNameDBE.要介護認定結果情報提供票_主治医__宛先敬称,
                                RDate.getNowDate(), SubGyomuCode.DBE認定支援)).get名称(),
                entity.getHihokenshaNo(),
                通知文.get(2),
                宛先情報.getTemp_宛名郵便番号().value());
        return headItem;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.gemmen.gemmen;

import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen.GemmenCsvEntity;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBBMN61002_介護保険料減免登録(一括)のCsvEditor
 *
 * @reamsid_L DBB-1670-030 surun
 */
public class GemmenCsvEditor {

    /**
     * editor
     *
     * @param entity DbT2002FukaJohoTempTableEntity
     * @param 賦課の情報一時Data DbT2002FukaJohoTempTableEntity
     * @param 宛名Entity UaFt200FindShikibetsuTaishoEntity
     * @return GemmenCsvEntity
     */
    public GemmenCsvEntity editor(DbT2002FukaJohoTempTableEntity entity, DbT2002FukaJohoTempTableEntity 賦課の情報一時Data,
            UaFt200FindShikibetsuTaishoEntity 宛名Entity) {
        GemmenCsvEntity csvEntity = new GemmenCsvEntity();
        if (entity.getChoteiNendo() != null) {
            csvEntity.set調定年度(entity.getChoteiNendo().toDateString());
        }
        if (entity.getFukaNendo() != null) {
            csvEntity.set賦課年度(entity.getFukaNendo().toDateString());
        }
        if (entity.getTsuchishoNo() != null) {
            csvEntity.set通知書番号(entity.getTsuchishoNo().getColumnValue());
        }
        csvEntity.set履歴番号(new RString(entity.getRirekiNo() + 1));
        if (entity.getHihokenshaNo() != null) {
            csvEntity.set被保険者番号(entity.getHihokenshaNo().getColumnValue());
        }
        ShikibetsuCode 識別コード = entity.getShikibetsuCode();
        if (識別コード != null) {
            csvEntity.set識別コード(識別コード.getColumnValue());
        }
        SetaiCode 世帯コード = entity.getSetaiCode();
        if (世帯コード != null) {
            csvEntity.set世帯コード(世帯コード.getColumnValue());
        }
        HokenryoDankaiSettings hokenryoDankaiSettings = HokenryoDankaiSettings.createInstance();
        HokenryoDankaiList 保険料段階リスト = hokenryoDankaiSettings.get保険料段階ListIn(entity.getFukaNendo());
        if (entity.getHokenryoDankai() != null) {
            HokenryoDankai 保険料段階 = 保険料段階リスト.getBy段階区分(entity.getHokenryoDankai());
            if (保険料段階 != null) {
                csvEntity.set保険料段階(保険料段階.get表記());
            }
        }
        csvEntity.set処理前減免前介護保険料年額(numToRString(entity.getGemmenMaeHokenryo()));
        csvEntity.set処理後減免前介護保険料年額(numToRString(賦課の情報一時Data.getGemmenMaeHokenryo()));
        csvEntity.set処理前減免額(numToRString(entity.getGemmenGaku()));
        csvEntity.set処理後減免額(numToRString(賦課の情報一時Data.getGemmenMaeHokenryo()));
        csvEntity.set処理前確定介護保険料年額(numToRString(entity.getKakuteiHokenryo()));
        csvEntity.set処理後確定介護保険料年額(numToRString(Decimal.ZERO));
        csvEntity.set処理前特徴期別金額01(numToRString(entity.getTkKibetsuGaku01()));
        csvEntity.set処理後特徴期別金額01(numToRString(Decimal.ZERO));
        csvEntity.set処理前特徴期別金額02(numToRString(entity.getTkKibetsuGaku02()));
        csvEntity.set処理後特徴期別金額02(numToRString(Decimal.ZERO));
        csvEntity.set処理前特徴期別金額03(numToRString(entity.getTkKibetsuGaku03()));
        csvEntity.set処理後特徴期別金額03(numToRString(Decimal.ZERO));
        csvEntity.set処理前特徴期別金額04(numToRString(entity.getTkKibetsuGaku04()));
        csvEntity.set処理後特徴期別金額04(numToRString(Decimal.ZERO));
        csvEntity.set処理前特徴期別金額05(numToRString(entity.getTkKibetsuGaku05()));
        csvEntity.set処理後特徴期別金額05(numToRString(Decimal.ZERO));
        csvEntity.set処理前特徴期別金額06(numToRString(entity.getTkKibetsuGaku06()));
        csvEntity.set処理後特徴期別金額06(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額01(numToRString(entity.getFuKibetsuGaku01()));
        csvEntity.set処理後普徴期別金額01(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額02(numToRString(entity.getFuKibetsuGaku02()));
        csvEntity.set処理後普徴期別金額02(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額03(numToRString(entity.getFuKibetsuGaku03()));
        csvEntity.set処理後普徴期別金額03(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額04(numToRString(entity.getFuKibetsuGaku04()));
        csvEntity.set処理後普徴期別金額04(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額05(numToRString(entity.getFuKibetsuGaku05()));
        csvEntity.set処理後普徴期別金額05(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額06(numToRString(entity.getFuKibetsuGaku06()));
        csvEntity.set処理後普徴期別金額06(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額07(numToRString(entity.getFuKibetsuGaku07()));
        csvEntity.set処理後普徴期別金額07(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額08(numToRString(entity.getFuKibetsuGaku08()));
        csvEntity.set処理後普徴期別金額08(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額09(numToRString(entity.getFuKibetsuGaku09()));
        csvEntity.set処理後普徴期別金額09(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額10(numToRString(entity.getFuKibetsuGaku10()));
        csvEntity.set処理後普徴期別金額10(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額11(numToRString(entity.getFuKibetsuGaku11()));
        csvEntity.set処理後普徴期別金額11(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額12(numToRString(entity.getFuKibetsuGaku12()));
        csvEntity.set処理後普徴期別金額12(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額13(numToRString(entity.getFuKibetsuGaku13()));
        csvEntity.set処理後普徴期別金額13(numToRString(Decimal.ZERO));
        csvEntity.set処理前普徴期別金額14(numToRString(entity.getFuKibetsuGaku14()));
        csvEntity.set処理後普徴期別金額14(numToRString(Decimal.ZERO));
        set宛名(csvEntity, 宛名Entity);
        return csvEntity;
    }

    private void set宛名(GemmenCsvEntity csvEntity, UaFt200FindShikibetsuTaishoEntity 宛名Entity) {
        if (宛名Entity != null) {
            ChoikiCode 町域コード = 宛名Entity.getChoikiCode();
            if (町域コード != null) {
                csvEntity.set町域コード(町域コード.getColumnValue());
            }
            AtenaJusho 住所 = 宛名Entity.getJusho();
            if (住所 != null) {
                csvEntity.set住所(住所.getColumnValue());
            }
            AtenaBanchi 番地 = 宛名Entity.getBanchi();
            if (番地 != null) {
                csvEntity.set番地(番地.getColumnValue());
            }
            Katagaki 方書 = 宛名Entity.getKatagaki();
            if (方書 != null) {
                csvEntity.set方書(方書.getColumnValue());
            }
            GyoseikuCode 行政区コード = 宛名Entity.getGyoseikuCode();
            if (行政区コード != null) {
                csvEntity.set行政区コード(行政区コード.getColumnValue());
            }
            csvEntity.set行政区名(宛名Entity.getGyoseikuName());
            ChikuCode 地区コード１ = 宛名Entity.getChikuCode1();
            if (地区コード１ != null) {
                csvEntity.set地区コード１(地区コード１.getColumnValue());
            }
            csvEntity.set地区名１(宛名Entity.getChikuName1());
            ChikuCode 地区コード２ = 宛名Entity.getChikuCode2();
            if (地区コード２ != null) {
                csvEntity.set地区コード２(地区コード２.getColumnValue());
            }
            csvEntity.set地区名２(宛名Entity.getChikuName2());
            ChikuCode 地区コード３ = 宛名Entity.getChikuCode3();
            if (地区コード３ != null) {
                csvEntity.set地区コード３(地区コード３.getColumnValue());
            }
            csvEntity.set地区名３(宛名Entity.getChikuName3());
            FlexibleDate 生年月日 = 宛名Entity.getSeinengappiYMD();
            if (生年月日 != null) {
                csvEntity.set生年月日(new RString(生年月日.toString()));
            }
            AtenaMeisho 漢字氏名 = 宛名Entity.getKanjiShimei();
            if (漢字氏名 != null) {
                csvEntity.set漢字氏名(漢字氏名.getColumnValue());
            }
            AtenaKanaMeisho カナ氏名 = 宛名Entity.getKanaShimei();
            if (カナ氏名 != null) {
                csvEntity.setカナ氏名(カナ氏名.getColumnValue());
            }
        }
    }

    private RString numToRString(Decimal 数字) {
        if (数字 == null) {
            return RString.EMPTY;
        }
        return new RString(数字.toString());
    }

}

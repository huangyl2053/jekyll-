/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenfukajoho;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen.GemmenEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課の情報一時テーブル処理前
 *
 * @reamsid_L DBB-1670-030 surun
 */
public class FukaJohoTempResult {

    private static final int 期1 = 1;
    private static final int 期2 = 2;
    private static final int 期3 = 3;
    private static final int 期4 = 4;
    private static final int 期5 = 5;
    private static final int 期6 = 6;
    private static final int 期7 = 7;
    private static final int 期8 = 8;
    private static final int 期9 = 9;
    private static final int 期10 = 10;
    private static final int 期11 = 11;
    private static final int 期12 = 12;
    private static final int 期13 = 13;
    private static final int 期14 = 14;
    private static final RString 徴収方法1 = new RString("1");
    private static final RString 徴収方法2 = new RString("2");

    /**
     * get処理前Entity
     *
     * @param 処理前Entity DbT2002FukaJohoTempTableEntity
     * @param entity GemmenEntity
     * @return DbT2002FukaJohoTempTableEntity
     */
    public DbT2002FukaJohoTempTableEntity get処理前Entity(DbT2002FukaJohoTempTableEntity 処理前Entity, GemmenEntity entity) {
        set期別金額(処理前Entity, entity);
        return 処理前Entity;
    }

    private void set期別金額(DbT2002FukaJohoTempTableEntity 処理前Entity, GemmenEntity entity) {
        DbT2003KibetsuEntity 介護期別 = entity.get介護期別();
        UrT0705ChoteiKyotsuEntity 調定共通 = entity.get調定共通();
        if (介護期別 != null && 調定共通 != null) {
            if (徴収方法1.equals(介護期別.getChoshuHouhou())) {
                set特徴期期別金額(調定共通.getChoteigaku(), 介護期別.getKi(), 処理前Entity);
            }
            if (徴収方法2.equals(介護期別.getChoshuHouhou())) {
                set普徴期期別金額(調定共通.getChoteigaku(), 介護期別.getKi(), 処理前Entity);
            }
        }
    }

    private void set特徴期期別金額(Decimal choteigaku, int ki, DbT2002FukaJohoTempTableEntity 処理前Entity) {
        switch (ki) {
            case 期1:
                処理前Entity.setTkKibetsuGaku01(choteigaku);
                break;
            case 期2:
                処理前Entity.setTkKibetsuGaku02(choteigaku);
                break;
            case 期3:
                処理前Entity.setTkKibetsuGaku03(choteigaku);
                break;
            case 期4:
                処理前Entity.setTkKibetsuGaku04(choteigaku);
                break;
            case 期5:
                処理前Entity.setTkKibetsuGaku05(choteigaku);
                break;
            case 期6:
                処理前Entity.setTkKibetsuGaku06(choteigaku);
                break;
            default:
                break;
        }
    }

    private void set普徴期期別金額(Decimal choteigaku, int ki, DbT2002FukaJohoTempTableEntity 処理前Entity) {
        switch (ki) {
            case 期1:
                処理前Entity.setFuKibetsuGaku01(choteigaku);
                break;
            case 期2:
                処理前Entity.setFuKibetsuGaku02(choteigaku);
                break;
            case 期3:
                処理前Entity.setFuKibetsuGaku03(choteigaku);
                break;
            case 期4:
                処理前Entity.setFuKibetsuGaku04(choteigaku);
                break;
            case 期5:
                処理前Entity.setFuKibetsuGaku05(choteigaku);
                break;
            case 期6:
                処理前Entity.setFuKibetsuGaku06(choteigaku);
                break;
            case 期7:
                処理前Entity.setFuKibetsuGaku07(choteigaku);
                break;
            case 期8:
                処理前Entity.setFuKibetsuGaku08(choteigaku);
                break;
            case 期9:
                処理前Entity.setFuKibetsuGaku09(choteigaku);
                break;
            case 期10:
                処理前Entity.setFuKibetsuGaku10(choteigaku);
                break;
            case 期11:
                処理前Entity.setFuKibetsuGaku11(choteigaku);
                break;
            case 期12:
                処理前Entity.setFuKibetsuGaku12(choteigaku);
                break;
            case 期13:
                処理前Entity.setFuKibetsuGaku13(choteigaku);
                break;
            case 期14:
                処理前Entity.setFuKibetsuGaku14(choteigaku);
                break;
            default:
                break;
        }
    }

}

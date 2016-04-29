/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.keisangojoho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 計算後情報作成ですためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class KeisangoJohoSakuseiProcessParamter implements IBatchProcessParameter {

    private final RString choteiNendo;
    private final RString fukaNendo;
    private final RString choteiNichiji;
    private final RString sakuseiShoriName;
    private final RString chohyoBunruiID;
    private final boolean saishinFlag1;
    private final boolean saishinFlag2;
    private final boolean saishinFlag3;
    private final boolean saishinFlag4;
    private final boolean saishinFlag5;
    private final boolean 更新前フラグ;

    /**
     * コンストラクタです。
     *
     * @param choteiNendo 調定年度
     * @param fukaNendo 賦課年度
     * @param choteiNichiji 調定日時
     * @param sakuseiShoriName 作成処理名
     * @param chohyoBunruiID 帳票分類ID
     * @param 更新前フラグ 更新前フラグ
     * @param saishinFlag1 調定年度或いは賦課年度が空
     * @param saishinFlag2 調定日時が空且つ帳票分類IDが空
     * @param saishinFlag3 調定日時が非空且つ帳票分類IDが空
     * @param saishinFlag4 調定日時が空且つ帳票分類IDが非空
     * @param saishinFlag5 調定日時が非空且つ帳票分類IDが非空
     *
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KeisangoJohoSakuseiProcessParamter(
            RString choteiNendo,
            RString fukaNendo,
            RString choteiNichiji,
            RString sakuseiShoriName,
            RString chohyoBunruiID,
            boolean 更新前フラグ,
            boolean saishinFlag1,
            boolean saishinFlag2,
            boolean saishinFlag3,
            boolean saishinFlag4,
            boolean saishinFlag5) {
        this.choteiNendo = choteiNendo;
        this.fukaNendo = fukaNendo;
        this.choteiNichiji = choteiNichiji;
        this.sakuseiShoriName = sakuseiShoriName;
        this.chohyoBunruiID = chohyoBunruiID;
        this.saishinFlag1 = saishinFlag1;
        this.saishinFlag2 = saishinFlag2;
        this.saishinFlag3 = saishinFlag3;
        this.saishinFlag4 = saishinFlag4;
        this.saishinFlag5 = saishinFlag5;
        this.更新前フラグ = 更新前フラグ;
    }

    /**
     * コンストラクタです。
     *
     * @param choteiNendo 調定年度
     * @param fukaNendo 賦課年度
     * @param choteiNichiji 調定日時
     * @param sakuseiShoriName 作成処理名
     * @param chohyoBunruiID 帳票分類ID
     * @param 更新前フラグ 更新前フラグ
     *
     * @return KeisangoJohoSakuseiProcessParamter
     */
    public static KeisangoJohoSakuseiProcessParamter createKeisangoJohoSakuseiProcessParamter(
            RString choteiNendo,
            RString fukaNendo,
            RString choteiNichiji,
            RString sakuseiShoriName,
            RString chohyoBunruiID,
            boolean 更新前フラグ) {

        boolean saishinFlag1 = false;
        boolean saishinFlag2 = false;
        boolean saishinFlag3 = false;
        boolean saishinFlag4 = false;
        boolean saishinFlag5 = false;
        if (RString.isNullOrEmpty(choteiNendo) || RString.isNullOrEmpty(fukaNendo)) {
            saishinFlag1 = true;
        } else if (RString.isNullOrEmpty(choteiNichiji) && RString.isNullOrEmpty(chohyoBunruiID)) {
            saishinFlag2 = true;
        } else if (!RString.isNullOrEmpty(choteiNichiji) && RString.isNullOrEmpty(chohyoBunruiID)) {
            saishinFlag3 = true;
        } else if (RString.isNullOrEmpty(choteiNichiji) && !RString.isNullOrEmpty(chohyoBunruiID)) {
            saishinFlag4 = true;
        } else if (!RString.isNullOrEmpty(choteiNichiji) && !RString.isNullOrEmpty(chohyoBunruiID)) {
            saishinFlag5 = true;
        }
        return new KeisangoJohoSakuseiProcessParamter(choteiNendo,
                fukaNendo,
                choteiNichiji,
                sakuseiShoriName,
                chohyoBunruiID,
                更新前フラグ,
                saishinFlag1,
                saishinFlag2,
                saishinFlag3,
                saishinFlag4,
                saishinFlag5);
    }

}

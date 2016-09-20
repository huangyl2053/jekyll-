/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB003001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.keisangojoho.KeisangoJohoSakuseiProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 計算後情報作成ですためのバッチ用パラメータクラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 *
 */
@Getter
@Setter
public class DBB003001_KeisangoJohoSakuseiParameter extends BatchParameterBase {

    private static final String CHOTEINENDO = "choteiNendo";
    private static final String FUKANENDO = "fukaNendo";
    private static final String CHOTEINICHIJI = "choteiNichiji";
    private static final String SAKUSEISHORINAME = "sakuseiShoriName";
    private static final String CHOHYOBUNRUIID = "chohyoBunruiID";
    private boolean 更新前フラグ;

    @BatchParameter(key = CHOTEINENDO, name = "調定年度")
    private RString choteiNendo;
    @BatchParameter(key = FUKANENDO, name = "賦課年度")
    private RString fukaNendo;
    @BatchParameter(key = CHOTEINICHIJI, name = "調定日時")
    private RString choteiNichiji;
    @BatchParameter(key = SAKUSEISHORINAME, name = "作成処理名")
    private RString sakuseiShoriName;
    @BatchParameter(key = CHOHYOBUNRUIID, name = "帳票分類ID")
    private RString chohyoBunruiID;

    /**
     * コンストラクタです。
     *
     * @param choteiNendo 調定年度
     * @param fukaNendo 賦課年度
     * @param choteiNichiji 調定日時
     * @param sakuseiShoriName 作成処理名
     * @param chohyoBunruiID 帳票分類ID
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public DBB003001_KeisangoJohoSakuseiParameter(
            RString choteiNendo,
            RString fukaNendo,
            RString choteiNichiji,
            RString sakuseiShoriName,
            RString chohyoBunruiID) {
        this.choteiNendo = choteiNendo;
        this.fukaNendo = fukaNendo;
        this.choteiNichiji = choteiNichiji;
        this.sakuseiShoriName = sakuseiShoriName;
        this.chohyoBunruiID = chohyoBunruiID;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return KeisangoJohoSakuseiProcessParamter
     */
    public KeisangoJohoSakuseiProcessParamter toKeisangoJohoSakuseiProcessParamter() {
        return KeisangoJohoSakuseiProcessParamter.createKeisangoJohoSakuseiProcessParamter(choteiNendo,
                fukaNendo,
                choteiNichiji,
                sakuseiShoriName,
                chohyoBunruiID,
                更新前フラグ);
    }
}

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
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KeisangoJohoSakuseiProcessParamter implements IBatchProcessParameter {

    private final RString choteiNendo;
    private final RString fukaNendo;
    private final RString choteiNichiji;
    private final RString sakuseiShoriName;
    private final RString chohyoBunruiID;

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
    public KeisangoJohoSakuseiProcessParamter(
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
}

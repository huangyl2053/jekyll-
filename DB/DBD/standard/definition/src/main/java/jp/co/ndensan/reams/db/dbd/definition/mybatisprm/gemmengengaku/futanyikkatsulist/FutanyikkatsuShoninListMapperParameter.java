/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.futanyikkatsulist;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担一括承認結果一覧（画面）_SQL使用パラメタークラスです.
 *
 * @reamsid_L DBD-3710-080 xuejm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FutanyikkatsuShoninListMapperParameter implements IMyBatisParameter {

    private YMDHMS システム日時;
    private YMDHMS システム日時の1年前;
    private YMDHMS 一括認定バッチ処理日時;
    private RString 減免減額種類_負担限度額認定;

    /**
     * 負担一括承認結果一覧（画面）の引数を返します。
     *
     * @param システム日時 YMDHMS
     * @param システム日時の1年前 YMDHMS
     */
    public FutanyikkatsuShoninListMapperParameter(YMDHMS システム日時, YMDHMS システム日時の1年前) {
        this.システム日時 = システム日時;
        this.システム日時の1年前 = システム日時の1年前;
    }

    /**
     * 負担一括承認結果一覧（画面）の引数を返します。
     *
     * @param 一括認定バッチ処理日時 YMDHMS
     * @param 減免減額種類_負担限度額認定 RString
     */
    public FutanyikkatsuShoninListMapperParameter(YMDHMS 一括認定バッチ処理日時, RString 減免減額種類_負担限度額認定) {
        this.一括認定バッチ処理日時 = 一括認定バッチ処理日時;
        this.減免減額種類_負担限度額認定 = 減免減額種類_負担限度額認定;
    }
}

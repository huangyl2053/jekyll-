/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt22006.NinteiBatchTaishoTokuteiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担限度額認定申請一括承認（バッチ）_処理対象の特定のProcessパラメータクラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiBatchTaishoTokuteiProcessParameter implements IBatchProcessParameter {

    private YMDHMS バッチ処理日時;
    private FlexibleDate 決定日;
    private FlexibleYear 作成年度;
    private boolean テスト処理;
    private FlexibleDate 申請日開始;
    private FlexibleDate 申請日終了;

    /**
     * コンストラクタです。
     *
     * @param バッチ処理日時 バッチ処理日時
     * @param 決定日 決定日
     * @param 作成年度 作成年度
     * @param テスト処理 テスト処理
     * @param 申請日開始 申請日開始
     * @param 申請日終了 申請日終了
     */
    public NinteiBatchTaishoTokuteiProcessParameter(
            YMDHMS バッチ処理日時,
            FlexibleDate 決定日,
            FlexibleYear 作成年度,
            boolean テスト処理,
            FlexibleDate 申請日開始,
            FlexibleDate 申請日終了) {
        this.バッチ処理日時 = バッチ処理日時;
        this.決定日 = 決定日;
        this.作成年度 = 作成年度;
        this.テスト処理 = テスト処理;
        this.申請日開始 = 申請日開始;
        this.申請日終了 = 申請日終了;
    }

    /**
     * バッチMybatisパラメターを取得します．
     *
     * @return NinteiBatchTaishoTokuteiMybatisParameter
     */
    public NinteiBatchTaishoTokuteiMybatisParameter toNinteiBatchTaishoTokuteiMybatisParameter() {
        return new NinteiBatchTaishoTokuteiMybatisParameter(申請日開始, 申請日終了);
    }
}

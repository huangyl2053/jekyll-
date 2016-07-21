/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokubetsuchoshudoteimidoteiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 特徴対象者一覧作成のバッチ起動時に設定される<br>
 * 特別徴収同定・未同定一覧表作成パラメータ
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 処理年度;
    private List<RString> 捕捉月;
    private RString 特別徴収開始月;
    private RString 出力対象;
    private YMDHMS 処理日時;
    private RString 通知内容コード;
    private IShikibetsuTaishoPSMSearchKey atenaKey;

    /**
     * コンストラクタです。
     *
     * @param 処理年度 処理年度
     * @param 捕捉月 捕捉月
     * @param 特別徴収開始月 特別徴収開始月
     * @param 出力対象 出力対象
     * @param 処理日時 処理日時
     */
    public TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter(FlexibleYear 処理年度, List<RString> 捕捉月, RString 特別徴収開始月,
            RString 出力対象, YMDHMS 処理日時) {
        this.処理年度 = 処理年度;
        this.捕捉月 = 捕捉月;
        this.特別徴収開始月 = 特別徴収開始月;
        this.出力対象 = 出力対象;
        this.処理日時 = 処理日時;
    }

    /**
     * インスタンスを生成します。
     *
     * @return {@link TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter}
     */
    public TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter getMybatisParameter() {
        return new TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter(処理年度.toDateString(), 特別徴収開始月, 捕捉月, 通知内容コード, atenaKey);
    }

}

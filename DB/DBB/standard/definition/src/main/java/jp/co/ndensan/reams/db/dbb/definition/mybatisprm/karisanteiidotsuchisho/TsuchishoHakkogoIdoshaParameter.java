/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho;

import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.NonNull;

/**
 * 出力対象データを抽出し、通知書発行後異動者テーブルに登録するパラメータです。
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TsuchishoHakkogoIdoshaParameter {

    private final RString 帳票ID;
    private final YMDHMS 帳票作成日時;
    private final RString 出力順;
    private final RString 更正前情報有無区分;

    private TsuchishoHakkogoIdoshaParameter(
            @NonNull RString 帳票ID,
            @NonNull YMDHMS 帳票作成日時,
            @NonNull RString 更正前情報有無区分,
            @NonNull RString 出力順) {
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
        this.更正前情報有無区分 = 更正前情報有無区分;
        this.出力順 = 出力順;
    }

    /**
     * パラメータを作成する。
     *
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     * @param 更正前情報有無区分 更正前情報有無区分
     * @param 出力順 出力順
     * @return 作成されたパラメータ
     */
    public static TsuchishoHakkogoIdoshaParameter createParameter(
            @NonNull RString 帳票ID,
            @NonNull YMDHMS 帳票作成日時,
            @NonNull RString 更正前情報有無区分,
            @NonNull RString 出力順) {
        return new TsuchishoHakkogoIdoshaParameter(帳票ID, 帳票作成日時, 更正前情報有無区分, 出力順);
    }
}

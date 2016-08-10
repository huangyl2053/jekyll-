/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheinjunkakakutei.RegistShoriDateKanriProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheinjunkakakutei.ShotokujohoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT51003_所得情報一覧表作成のParameterです。
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokujohoIchiranhyoSakuseiBatchParameter extends BatchParameterBase {

    private static final String KEY_導入形態コード = "導入形態コード";
    private static final String NAME_導入形態コード = "導入形態コード";
    private static final String KEY_市町村コード = "市町村コード";
    private static final String NAME_市町村コード = "市町村コード";
    private static final String KEY_市町村名称 = "市町村名称";
    private static final String NAME_市町村名称 = "市町村名称";
    private static final String KEY_処理年度 = "処理年度";
    private static final String NAME_処理年度 = "処理年度";
    private static final String KEY_チェックボックス = "チェックボックス";
    private static final String NAME_チェックボックス = "チェックボックス";
    private static final String KEY_ラジオボタン = "ラジオボタン";
    private static final String NAME_ラジオボタン = "ラジオボタン";
    private static final String KEY_開始日時 = "開始日時";
    private static final String NAME_開始日時 = "開始日時";
    private static final String KEY_終了日時 = "終了日時";
    private static final String NAME_終了日時 = "終了日時";
    private static final String KEY_市町村情報リスト = "市町村情報リスト";
    private static final String NAME_市町村情報リスト = "市町村情報リスト";
    private static final String KEY_出力順ID = "出力順ID";
    private static final String NAME_出力順ID = "出力順ID";

    @BatchParameter(key = KEY_導入形態コード, name = NAME_導入形態コード)
    private RString 導入形態コード;
    @BatchParameter(key = KEY_市町村コード, name = NAME_市町村コード)
    private LasdecCode 市町村コード;
    @BatchParameter(key = KEY_市町村名称, name = NAME_市町村名称)
    private RString 市町村名称;
    @BatchParameter(key = KEY_処理年度, name = NAME_処理年度)
    private FlexibleYear 処理年度;
    @BatchParameter(key = KEY_チェックボックス, name = NAME_チェックボックス)
    private RString チェックボックス;
    @BatchParameter(key = KEY_ラジオボタン, name = NAME_ラジオボタン)
    private RString ラジオボタン;
    @BatchParameter(key = KEY_開始日時, name = NAME_開始日時)
    private YMDHMS 開始日時;
    @BatchParameter(key = KEY_終了日時, name = NAME_終了日時)
    private YMDHMS 終了日時;
    @BatchParameter(key = KEY_市町村情報リスト, name = NAME_市町村情報リスト)
    private List<ShichosonJouhouResult> 市町村情報リスト;
    @BatchParameter(key = KEY_出力順ID, name = NAME_出力順ID)
    private Long 出力順ID;

    /**
     * toProcessParameterメソッドです。
     *
     * @return ShotokujohoIchiranhyoSakuseiProcessParameter
     */
    public ShotokujohoIchiranhyoSakuseiProcessParameter toProcessParameter() {
        return new ShotokujohoIchiranhyoSakuseiProcessParameter(導入形態コード,
                市町村コード,
                市町村名称,
                処理年度,
                チェックボックス,
                ラジオボタン,
                開始日時,
                終了日時,
                市町村情報リスト,
                出力順ID,
                null,
                null);
    }

    /**
     * toRegistShoriDateKanriProcessParameterメソッドです。
     *
     * @return RegistShoriDateKanriProcessParameter
     */
    public RegistShoriDateKanriProcessParameter toRegistShoriDateKanriProcessParameter() {
        return new RegistShoriDateKanriProcessParameter(導入形態コード, 処理年度, 開始日時, 終了日時, 市町村コード,
                市町村名称, FlexibleDate.MAX, FlexibleDate.MAX, RString.EMPTY, RString.EMPTY, 市町村情報リスト);
    }
}

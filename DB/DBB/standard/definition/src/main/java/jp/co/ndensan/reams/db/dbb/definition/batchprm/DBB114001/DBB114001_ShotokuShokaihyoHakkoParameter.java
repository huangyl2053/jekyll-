/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB114001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.KoikiZenShichosonJohoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.SaiHakkoParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT51001_所得照会票一括発行のパラメタ
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB114001_ShotokuShokaihyoHakkoParameter extends BatchParameterBase {

    private static final String NAME_処理年度 = "処理年度";
    private static final String KEY_処理年度 = "shorinendo";
    private static final String NAME_照会年月日 = "照会年月日";
    private static final String KEY_照会年月日 = "shoukaiYMD";
    private static final String NAME_出力順ID = "出力順ID";
    private static final String KEY_出力順ID = "shutsuryokujunID";
    private static final String NAME_出力順 = "出力順I";
    private static final String KEY_出力順 = "shutsuryokujun";
    private static final String NAME_改頁項目ID = "改頁項目ID";
    private static final String KEY_改頁項目ID = "kaipageID";
    private static final String NAME_導入形態コード = "導入形態コード";
    private static final String KEY_導入形態コード = "donyuKeitaiCode";
    private static final String NAME_構成市町村情報リスト = "構成市町村情報リスト";
    private static final String KEY_構成市町村情報リスト = "shichosonJohoList";
    private static final String NAME_再発行対象リスト = "構成市町村情報リスト";
    private static final String KEY_再発行対象リスト = "saihaqkouList";
    private static final String NAME_テストプリント = "テストプリント";
    private static final String KEY_テストプリント = "testPrint";
    private static final String NAME_出力対象 = "出力対象";
    private static final String KEY_出力対象 = "shutuRyoku";

    @BatchParameter(key = KEY_処理年度, name = NAME_処理年度)
    private FlexibleYear 処理年度;
    @BatchParameter(key = KEY_照会年月日, name = NAME_照会年月日)
    private FlexibleDate 照会年月日;
    @BatchParameter(key = KEY_出力対象, name = NAME_出力対象)
    private RString 出力対象;
    @BatchParameter(key = KEY_テストプリント, name = NAME_テストプリント)
    private boolean テストプリント;
    @BatchParameter(key = KEY_再発行対象リスト, name = NAME_再発行対象リスト)
    private List<SaiHakkoParameter> 再発行対象リスト;
    @BatchParameter(key = KEY_出力順ID, name = NAME_出力順ID)
    private Long 出力順ID;
    @BatchParameter(key = KEY_導入形態コード, name = NAME_導入形態コード)
    private RString 導入形態コード;
    @BatchParameter(key = KEY_構成市町村情報リスト, name = NAME_構成市町村情報リスト)
    private List<KoikiZenShichosonJohoParameter> 構成市町村情報リスト;
    @BatchParameter(key = KEY_出力順, name = NAME_出力順)
    private RString 出力順;
    @BatchParameter(key = KEY_改頁項目ID, name = NAME_改頁項目ID)
    private RString 改頁項目ID;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200088_基準収入額適用申請書一覧表 Editorクラスです。
 *
 * @reamsid_L DBC-4640-060 lijian
 */
public class KijunShunyugakuTekiyoShinseishoHakkoIchiranEditor implements IKijunShunyugakuTekiyoShinseishoHakkoIchiranEditor {

    private final KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 発行対象者;
    private final RString 市町村番号;
    private final RString 市町村名;
    private final List<RString> 出力順リスト;
    private final List<RString> 改頁リスト;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param 発行対象者 KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity
     * @param 市町村番号 RString
     * @param 市町村名 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     */
    public KijunShunyugakuTekiyoShinseishoHakkoIchiranEditor(
            KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 発行対象者,
            RString 市町村番号,
            RString 市町村名,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト) {
        this.発行対象者 = 発行対象者;
        this.市町村番号 = 市町村番号;
        this.市町村名 = 市町村名;
        this.出力順リスト = 出力順リスト;
        this.改頁リスト = 改頁リスト;

    }

    @Override
    public KijunShunyugakuTekiyoShinseishoHakkoIchiranSource edit(KijunShunyugakuTekiyoShinseishoHakkoIchiranSource source) {
        source.printTimeStamp = YMDHMS.now().toDateString();
        source.hokenshaNo = 市町村番号;
        source.hokenshaName = 市町村名;
        edit出力順(source);
        edit改ページ(source);

        source.listIchiran_1 = 発行対象者.get通番();
        source.listIchiran_2 = 発行対象者.get世帯番号();
        source.listIchiran_3 = 発行対象者.get世帯課税();
        source.listIchiran_4 = 発行対象者.get総合計();
        source.listIchiran_5 = 発行対象者.get被保番号();
        source.listIchiran_6 = 発行対象者.get氏名();
        source.listIchiran_7 = 発行対象者.get年齢();
        source.listIchiran_9 = 発行対象者.get課税所得();
        source.listIchiran_10 = 発行対象者.get課税所得_控除後();
        source.listIchiran_11 = 発行対象者.get年金収入();
        source.listIchiran_12 = 発行対象者.getその他合計所得();
        source.listIchiran_13 = 発行対象者.get合計();
        source.listIchiran_14 = 発行対象者.get要介護度();
        if (発行対象者.get生年月日() != null) {
            source.listIchiran_8 = new RString(発行対象者.get生年月日().toString());
        }
        if (発行対象者.get認定開始日() != null) {
            source.listIchiran_15 = new RString(発行対象者.get認定開始日().toString());
        }
        if (発行対象者.get認定終了日() != null) {
            source.listIchiran_16 = new RString(発行対象者.get認定終了日().toString());
        }
        if (発行対象者.get識別コード() != null) {
            source.shikibetsuCode = 発行対象者.get識別コード().value();
        }
        return source;
    }

    private void edit出力順(KijunShunyugakuTekiyoShinseishoHakkoIchiranSource source) {
        source.shutsuryokujun1 = 出力順リスト.get(NUM_0);
        source.shutsuryokujun2 = 出力順リスト.get(NUM_1);
        source.shutsuryokujun3 = 出力順リスト.get(NUM_2);
        source.shutsuryokujun4 = 出力順リスト.get(NUM_3);
        source.shutsuryokujun5 = 出力順リスト.get(NUM_4);
    }

    private void edit改ページ(KijunShunyugakuTekiyoShinseishoHakkoIchiranSource source) {
        source.kaipage1 = 改頁リスト.get(NUM_0);
        source.kaipage2 = 改頁リスト.get(NUM_1);
        source.kaipage3 = 改頁リスト.get(NUM_2);
        source.kaipage4 = 改頁リスト.get(NUM_3);
        source.kaipage5 = 改頁リスト.get(NUM_4);
    }
}

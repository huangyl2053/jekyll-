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

    private final List<KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity> 発行対象者リスト;
    private final RString 市町村番号;
    private final RString 市町村名;
    private final List<RString> 出力順リスト;
    private final List<RString> 改頁リスト;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString 該当データなし = new RString("該当データなし");

    /**
     * コンストラクタです。
     *
     * @param 発行対象者リスト List<KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity>
     * @param 市町村番号 RString
     * @param 市町村名 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     */
    public KijunShunyugakuTekiyoShinseishoHakkoIchiranEditor(
            List<KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity> 発行対象者リスト,
            RString 市町村番号,
            RString 市町村名,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト) {
        this.発行対象者リスト = 発行対象者リスト;
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

        if (0 < 発行対象者リスト.size()) {
            for (KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity entity : 発行対象者リスト) {

                source.listIchiran_1 = entity.get通番();
                source.listIchiran_2 = entity.get世帯番号();
                source.listIchiran_3 = entity.get世帯課税();
                source.listIchiran_4 = entity.get総合計();
                source.listIchiran_5 = entity.get被保番号();
                source.listIchiran_6 = entity.get氏名();
                source.listIchiran_7 = entity.get年齢();
                source.listIchiran_9 = entity.get課税所得();
                source.listIchiran_10 = entity.get課税所得_控除後();
                source.listIchiran_11 = entity.get年金収入();
                source.listIchiran_12 = entity.getその他合計所得();
                source.listIchiran_13 = entity.get合計();
                source.listIchiran_14 = entity.get要介護度();
                if (entity.get生年月日() != null) {
                    source.listIchiran_8 = new RString(entity.get生年月日().toString());
                }
                if (entity.get認定開始日() != null) {
                    source.listIchiran_15 = new RString(entity.get認定開始日().toString());
                }
                if (entity.get認定終了日() != null) {
                    source.listIchiran_16 = new RString(entity.get認定終了日().toString());
                }
                if (entity.get識別コード() != null) {
                    source.shikibetsuCode = entity.get識別コード().value();
                }
            }
        } else {
            source.listIchiran_6 = 該当データなし;
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

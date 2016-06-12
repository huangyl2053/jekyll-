/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyoyobihanteikinyuhyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.jimukyokuyoyobihanteikinyuhyo.JimukyokuyoYobihanteiKinyuhyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyoyobihanteikinyuhyo.JimukyokuyoYobihanteiKinyuhyoReportSource;

/**
 * 事務局用予備判定記入表のEditorです。
 *
 * @reamsid_L DBE-0150-100 wangrenze
 */
public class JimukyokuyoYobihanteiKinyuhyoEditor implements IJimukyokuyoYobihanteiKinyuhyoEditor {

    private final JimukyokuyoYobihanteiKinyuhyoEntity item;

    /**
     * コンストラクタです。
     *
     * @param item {@link JimukyokuyoYobihanteiKinyuhyoEntity}
     */
    protected JimukyokuyoYobihanteiKinyuhyoEditor(JimukyokuyoYobihanteiKinyuhyoEntity item) {
        this.item = item;
    }

    /**
     * 事務局用予備判定記入表を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public JimukyokuyoYobihanteiKinyuhyoReportSource edit(JimukyokuyoYobihanteiKinyuhyoReportSource source) {
        source.printTimeStamp = item.get作成年月日();
        source.listTaishoshaIchiran_1 = item.get被保険者番号();
        source.listTaishoshaIchiran_2 = item.get氏名();
        source.listTaishoshaIchiran_3 = item.get性別();
        source.listTaishoshaIchiran_4 = item.get年齢();
        source.listTaishoshaIchiran_5 = item.get前回二次判定();
        source.listTaishoshaIchiran_6 = item.get前回認定有効期間();
        source.listTaishoshaIchiran_7 = item.get一次判定();
        source.listTaishoshaIchiran_8 = item.get二次判定();
        source.listTaishoshaIchiran_9 = item.get状態像();
        source.listTaishoshaIchiran_10 = item.get認定有効期間();
        source.listTokuteiShippeiName_1 = item.get特定疾病名称();
        source.listTokuteiShippeiCode_1 = item.get特定疾病コード();
        source.listIchijihanteiKeikokuCode_1 = item.get一次判定警告コード();
        source.listShinseiKubun_1 = item.get申請区分();
        source.listNo_1 = item.getNo();
        source.listHokenshaName_1 = item.get保険者();
        source.shinsakaiKaisaiNo = item.get審査会開催番号();
        source.kaisaiYMD = item.get開催年月日();
        source.kaisaiHH = item.get開催時();
        source.kaisaiMM = item.get開催分();
        source.gogitaiName = item.get合議体名称();
        return source;
    }
}

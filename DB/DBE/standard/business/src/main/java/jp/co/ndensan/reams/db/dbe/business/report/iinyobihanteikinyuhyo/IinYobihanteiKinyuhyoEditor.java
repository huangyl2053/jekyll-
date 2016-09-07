/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinyobihanteikinyuhyo;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IinYobihanteiKinyuhyoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinyobihanteikinyuhyo.IinYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用予備判定記入表のEditorです。
 *
 * @reamsid_L DBE-0150-150 wangrenze
 */
public class IinYobihanteiKinyuhyoEditor implements IIinYobihanteiKinyuhyoEditor {

    private static final int INT_4 = 4;
    private final IinYobihanteiKinyuhyoBusiness business;

    /**
     * コンストラクタです。
     *
     * @param business {@link IinYobihanteiKinyuhyoBusiness}
     */
    protected IinYobihanteiKinyuhyoEditor(IinYobihanteiKinyuhyoBusiness business) {
        this.business = business;
    }

    /**
     * 委員用予備判定記入表を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public IinYobihanteiKinyuhyoReportSource edit(IinYobihanteiKinyuhyoReportSource source) {
        source.printTimeStamp = business.get作成年月日();
        source.title = new RString("予備判定記入表");
        source.shinsakaiKaisaiNo = new RString("第").concat(business.get審査会開催番号().substring(business.get審査会開催番号()
                .length() - INT_4)).concat(new RString("回　審査会"));
        source.listTaishoshaIchiran_1 = business.getNo();
        source.listTaishoshaIchiran_2 = business.get申請区分();
        source.listTaishoshaIchiran_5 = business.get被保険者区分();
        source.listTaishoshaIchiran_3 = business.get性別();
        source.listTaishoshaIchiran_4 = business.get年齢();
        source.listTaishoshaIchiran_6 = business.get前回二次判定();
        source.listTaishoshaIchiran_7 = business.get前回認定有効期間();
        source.listTaishoshaIchiran_8 = business.get一次判定();
        source.listTaishoshaIchiran_10 = RString.EMPTY;
        source.listTaishoshaIchiran_11 = RString.EMPTY;
        source.listTaishoshaIchiran_12 = RString.EMPTY;
        source.listTokuteiShippeiCode_1 = business.get特定疾病コード();
        source.listTokuteiShippeiName_1 = business.get特定疾病名称();

        return source;
    }
}

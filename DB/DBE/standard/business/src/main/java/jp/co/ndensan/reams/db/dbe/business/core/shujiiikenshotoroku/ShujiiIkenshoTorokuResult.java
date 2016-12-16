package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshotoroku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshotoroku.ShujiiIkenshoTorokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 主治医意見書登録のビジネスクラスです
 *
 * @reamsid_L DBE-0070-010 chengsanyuan
 */
public class ShujiiIkenshoTorokuResult {

    private final ShujiiIkenshoTorokuRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 主治医意見書登録RelateEntity
     */
    public ShujiiIkenshoTorokuResult(ShujiiIkenshoTorokuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査委託先コードを取得します。
     *
     * @return 意見書同意フラグ
     */
    public boolean is意見書同意フラグ() {
        return entity.getDbt5302Entity().getIkenshoDoiFlag();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        if (entity.getDbt5912Entity() == null) {
            return RString.EMPTY;
        } else {
            return entity.getDbt5912Entity().getShujiiName();
        }
    }

    /**
     * 認定調査員コードを取得します。
     *
     * @return 主治医意見書記入年月日
     */
    public FlexibleDate get主治医意見書記入年月日() {
        return entity.getDbt5302Entity().getIkenshoKinyuYMD();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        if (entity.getDbt5911Entity() == null) {
            return RString.EMPTY;
        } else {
            return entity.getDbt5911Entity().getIryoKikanMeisho();
        }
    }

    /**
     * 申請者人数を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getDbt5911Entity().getTelNo();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        if (entity.getDbt5911Entity() == null) {
            return RString.EMPTY;
        } else {
            return entity.getDbt5911Entity().getJusho();
        }
    }

    /**
     * FAX番号を取得します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getDbt5911Entity().getFaxNo();
    }

    /**
     * 最終診察日を取得します。
     *
     * @return 最終診察日
     */
    public FlexibleDate get最終診察日() {
        return entity.getDbt5302Entity().getSaishuShinryoYMD();
    }

    /**
     * 意見書作成回数区分を取得します。
     *
     * @return 意見書作成回数区分
     */
    public Code get意見書作成回数区分() {
        return entity.getDbt5302Entity().getIkenshoSakuseiKaisuKubun();
    }

    /**
     * 他科受診の有無を取得します。
     *
     * @return 他科受診の有無
     */
    public boolean is他科受診の有無() {
        return entity.getDbt5302Entity().getExistTakaJushinFlag();
    }

    /**
     * 内科受診の有無を取得します。
     *
     * @return 内科受診の有無
     */
    public boolean is内科受診の有無() {
        return entity.getDbt5302Entity().getExistNaikaJushinFlag();
    }

    /**
     * 精神科受診の有無を取得します。
     *
     * @return 精神科受診の有無
     */
    public boolean is精神科受診の有無() {
        return entity.getDbt5302Entity().getExistSeishinkaJushinFlag();
    }

    /**
     * 外科受診の有無を取得します。
     *
     * @return 外科受診の有無
     */
    public boolean is外科受診の有無() {
        return entity.getDbt5302Entity().getExistGekaJushinFlag();
    }

    /**
     * 整形外科受診の有無を取得します。
     *
     * @return 整形外科受診の有無
     */
    public boolean is整形外科受診の有無() {
        return entity.getDbt5302Entity().getExistSeikeigekaJushinFlag();
    }

    /**
     * 脳神経外科受診の有無を取得します。
     *
     * @return 脳神経外科受診の有無
     */
    public boolean is脳神経外科受診の有無() {
        return entity.getDbt5302Entity().getExistNoshinkeigekaJushinFlag();
    }

    /**
     * 皮膚科受診の有無を取得します。
     *
     * @return 皮膚科受診の有無
     */
    public boolean is皮膚科受診の有無() {
        return entity.getDbt5302Entity().getExistHifukaJushinFlag();
    }

    /**
     * 泌尿器科受診の有無を取得します。
     *
     * @return 泌尿器科受診の有無
     */
    public boolean is泌尿器科受診の有無() {
        return entity.getDbt5302Entity().getExistHinyokikaJushinFlag();
    }

    /**
     * 婦人科受診の有無を取得します。
     *
     * @return 婦人科受診の有無
     */
    public boolean is婦人科受診の有無() {
        return entity.getDbt5302Entity().getExistFujinkaJushinFlag();
    }

    /**
     * 眼科受診の有無を取得します。
     *
     * @return 眼科受診の有無
     */
    public boolean is眼科受診の有無() {
        return entity.getDbt5302Entity().getExistGankaJushinFlag();
    }

    /**
     * 耳鼻咽喉科受診の有無を取得します。
     *
     * @return 耳鼻咽喉科受診の有無
     */
    public boolean is耳鼻咽喉科受診の有無() {
        return entity.getDbt5302Entity().getExistJibiinkokaJushinFlag();
    }

    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ科受診の有無を取得します。
     *
     * @return ﾘﾊﾋﾞﾘﾃｰｼｮﾝ科受診の有無
     */
    public boolean isﾘﾊﾋﾞﾘﾃｰｼｮﾝ科受診の有無() {
        return entity.getDbt5302Entity().getExistRehabilitationkaJushinFlag();
    }

    /**
     * 歯科受診の有無を取得します。
     *
     * @return 歯科受診の有無
     */
    public boolean is歯科受診の有無() {
        return entity.getDbt5302Entity().getExistShikaJushinFlag();
    }

    /**
     * その他受診科の有無を取得します。
     *
     * @return その他受診科の有無
     */
    public boolean isその他受診科の有無() {
        return entity.getDbt5302Entity().getExistSonotaJushinkaFlag();
    }

    /**
     * その他受診科名を取得します。
     *
     * @return その他受診科名
     */
    public RString getその他受診科名() {
        return entity.getDbt5302Entity().getSonotaJushinKaMei();
    }

    /**
     * メモを取得します。
     *
     * @return メモ
     */
    public RString getメモ() {
        return entity.getDbt5302Entity().getIkenshoMemo();
    }

    /**
     * 厚労省IF識別コードを取得します。
     *
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return entity.getDbt5302Entity().getKoroshoIfShikibetsuCode();
    }

    /**
     * 主治医意見書作成依頼履歴番号を取得します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.getDbt5301Entity().getIkenshoIraiRirekiNo();
    }
}

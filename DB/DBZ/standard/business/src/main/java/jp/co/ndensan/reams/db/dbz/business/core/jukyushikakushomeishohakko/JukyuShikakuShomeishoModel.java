package jp.co.ndensan.reams.db.dbz.business.core.jukyushikakushomeishohakko;

import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.JukyuShikakuShomeishoHakkoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給資格証明書を表すクラスです。
 *
 * @reamsid_L DBA-1090-020 wangkun
 */
public class JukyuShikakuShomeishoModel {

    private final JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuEntity;

    /**
     * コンストラクタです。
     *
     * @param jukyuShikakuShomeishoHakko 介護認定審査会開催場所情報テーブルのエンティティクラスです
     */
    public JukyuShikakuShomeishoModel(JukyuShikakuShomeishoHakkoRelateEntity jukyuShikakuShomeishoHakko) {
        this.jukyuShikakuEntity = jukyuShikakuShomeishoHakko;
    }

    /**
     * 交付日を取得します。
     *
     * @return 交付日
     */
    public RString get交付日() {
        return FlexibleDate.getNowDate().wareki().toDateString();
    }

    /**
     * 異動予定日を取得します。
     *
     * @return 異動予定日
     */
    public RString get異動予定日() {
        if (jukyuShikakuEntity.getIdoYMD() != null
                && !jukyuShikakuEntity.getIdoYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuEntity.getIdoYMD()).wareki().toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 要介護状態区分を取得します。
     *
     * @return 要介護状態区分
     */
    public RString get要介護状態区分() {
        if (jukyuShikakuEntity.getYokaigoJotaiKubunCode() != null
                && !jukyuShikakuEntity.getYokaigoJotaiKubunCode().isEmpty()) {
            return YokaigoJotaiKubun09.toValue(jukyuShikakuEntity.getYokaigoJotaiKubunCode()).get名称();
        } else {
            return RString.EMPTY;
        }

    }

    /**
     * 有効期間開始日を取得します。
     *
     * @return 有効期間開始日
     */
    public RString get有効期間開始日() {
        if (jukyuShikakuEntity.getNinteiYukoKikanKaishiYMD() != null
                && !jukyuShikakuEntity.getNinteiYukoKikanKaishiYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuEntity
                    .getNinteiYukoKikanKaishiYMD()).wareki().toDateString();
        } else {
            return RString.EMPTY;
        }

    }

    /**
     * 受給申請年月日を取得します。
     *
     * @return 受給申請年月日
     */
    public RString get受給申請年月日() {
        if (jukyuShikakuEntity.getJukyuShinseiYMD() != null
                && !jukyuShikakuEntity.getJukyuShinseiYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuEntity.getJukyuShinseiYMD()).wareki().toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 有効期間終了日を取得します。
     *
     * @return 有効期間開始日
     */
    public RString get有効期間終了日() {
        if (jukyuShikakuEntity.getNinteiYukoKikanShuryoYMD() != null
                && !jukyuShikakuEntity.getNinteiYukoKikanShuryoYMD().isEmpty()) {
            return new FlexibleDate(jukyuShikakuEntity
                    .getNinteiYukoKikanShuryoYMD()).wareki().toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 介護認定審査会意見を取得します。
     *
     * @return 介護認定審査会意見
     */
    public RString get介護認定審査会意見() {
        if (jukyuShikakuEntity.getShinsakaiIken() != null
                && !jukyuShikakuEntity.getShinsakaiIken().isEmpty()) {
            return jukyuShikakuEntity.getShinsakaiIken();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 備考を取得します。
     *
     * @return 備考
     */
    public RString get備考() {
        if (jukyuShikakuEntity.getBiko() != null
                && !jukyuShikakuEntity.getBiko().isEmpty()) {
            return jukyuShikakuEntity.getBiko();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 負担割合を取得します。
     *
     * @return 負担割合
     */
    public RString get負担割合() {
        if (jukyuShikakuEntity.getFutanWariaiKubun() != null
                && !jukyuShikakuEntity.getFutanWariaiKubun().isEmpty()) {
            return FutanwariaiKubun.toValue(jukyuShikakuEntity.getFutanWariaiKubun()).get名称();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 負担割該当を取得します。
     *
     * @return 負担割該当
     */
    public RString get負担割該当() {
        if (jukyuShikakuEntity.getFutanWariai() != null
                && !jukyuShikakuEntity.getFutanWariai().isEmpty()) {
            return jukyuShikakuEntity.getFutanWariai();
        } else {
            return RString.EMPTY;
        }
    }

}

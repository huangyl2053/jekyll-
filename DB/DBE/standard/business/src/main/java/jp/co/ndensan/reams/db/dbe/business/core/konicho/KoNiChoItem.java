package jp.co.ndensan.reams.db.dbe.business.core.konicho;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jp.co.ndensan.reams.db.dbe.entity.db.relate.konicho.KoNiChoRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author soft863
 */
public class KoNiChoItem {

    private final KoNiChoRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 資格得喪Entity
     */
    public KoNiChoItem(KoNiChoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 認定調査員コードを取得します。
     *
     * @return 認定調査員コード
     */
    public ChosainCode get認定調査員コード() {
        return entity.getNinteiChosainNo();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 調査員カナを取得します。
     *
     * @return 調査員カナ
     */
    public RString get調査員カナ() {
        return entity.getChosainKanaShimei();
    }

    /**
     * 認定調査委託先コードを取得します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 地区コードを取得します。
     *
     * @return 地区コード
     */
    public RString get地区コード() {
        return entity.getChikuCode();
    }

    /**
     * 調査員資格を取得します。
     *
     * @return 調査員資格
     */
    public RString get調査員資格() {
        return entity.getChosainShikaku();
    }

    /**
     * 調査可能人数月を取得します。
     *
     * @return 調査可能人数月
     */
    public int get調査可能人数月() {
        return entity.getChosaKanoNinzuPerMonth();
    }

    /**
     * 状況フラグを取得します。
     *
     * @return 状況フラグ
     */
    public boolean get状況フラグ() {
        return entity.isJokyoFlag();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * FAX番号を取得します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

}

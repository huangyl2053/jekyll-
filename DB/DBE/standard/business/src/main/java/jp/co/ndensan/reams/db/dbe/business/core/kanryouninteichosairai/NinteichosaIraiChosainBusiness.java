/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.kanryouninteichosairai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairai.ChosaKekkaNyuryokuMobileChosainRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 完了処理・認定調査依頼のモバイル入力用データ（調査結果入力用調査員データ）のBusinessです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIraiChosainBusiness {

    private final ChosaKekkaNyuryokuMobileChosainRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity ChosaKekkaNyuryokuMobileChosainRelateEntity
     */
    public NinteichosaIraiChosainBusiness(ChosaKekkaNyuryokuMobileChosainRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 調査委託先コードを返します。
     *
     * @return 調査委託先コード
     */
    public RString get調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 調査委託先名称を返します。
     *
     * @return 調査委託先名称
     */
    public RString get調査委託先名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 調査委託先名称カナを返します。
     *
     * @return 調査委託先名称カナ
     */
    public RString get調査委託先名称カナ() {
        return entity.getJigyoshaMeishoKana();
    }

    /**
     * 調査委託先郵便番号を返します。
     *
     * @return 調査委託先郵便番号
     */
    public YubinNo get調査委託先郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 調査委託先住所を返します。
     *
     * @return 調査委託先住所
     */
    public RString get調査委託先住所() {
        return entity.getJusho();
    }

    /**
     * 調査委託先電話番号を返します。
     *
     * @return 調査委託先電話番号
     */
    public TelNo get調査委託先電話番号() {
        return entity.getTelNo();
    }

    /**
     * 調査委託FAX番号を返します。
     *
     * @return 調査委託FAX番号
     */
    public TelNo get調査委託先FAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 代表者名を返します。
     *
     * @return 代表者名
     */
    public RString get代表者名() {
        return entity.getDaihyoshaName();
    }

    /**
     * 代表者名カナを返します。
     *
     * @return 代表者名カナ
     */
    public RString get代表者名カナ() {
        return entity.getDaihyoshaNameKana();
    }

    /**
     * 調査委託区分を返します。
     *
     * @return 調査委託区分
     */
    public RString get調査委託区分() {
        return entity.getChosaItakuKubun();
    }

    /**
     * 特定調査員表示フラグを返します。
     *
     * @return 特定調査員表示フラグ True：表示　False：非表示
     */
    public boolean is特定調査員表示フラグ() {
        return entity.isTokuteiChosainDisplayFlag();
    }

    /**
     * 割付定員を返します。
     *
     * @return 割付定員
     */
    public int get割付定員() {
        return entity.getWaritsukeTeiin();
    }

    /**
     * 割付地区コードを返します。
     *
     * @return 割付地区コード
     */
    public ChikuCode get割付地区コード() {
        return entity.getWaritsukeChiku();
    }

    /**
     * 自動割付フラグを返します。
     *
     * @return 自動割付フラグ True：自動割付可能　False：自動割付不可能
     */
    public boolean is自動割付フラグ() {
        return entity.isAutoWaritsukeFlag();
    }

    /**
     * 機関の区分を返します。
     *
     * @return 機関の区分
     */
    public RString get機関の区分() {
        return entity.getKikanKubun();
    }

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ True：有効　False：無効
     */
    public boolean is状況フラグ() {
        return entity.isJokyoFlag();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    public RString get調査員氏名カナ() {
        return entity.getChosainKanaShimei();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public RString get地区コード() {
        return entity.getChikuCode();
    }

    /**
     * 調査員資格を返します。
     *
     * @return 調査員資格
     */
    public RString get調査員資格() {
        return entity.getChosainShikaku();
    }

    /**
     * 調査可能人数／月を返します。
     *
     * @return 調査可能人数／月
     */
    public int get調査可能人数月() {
        return entity.getChosaKanoNinzuPerMonth();
    }

    /**
     * 調査員状況フラグを返します。
     *
     * @return 調査員状況フラグ True：有効　False：無効
     */
    public boolean is調査員状況フラグ() {
        return entity.isChosainJokyoFlag();
    }

    /**
     * 調査員郵便番号を返します。
     *
     * @return 調査員郵便番号
     */
    public YubinNo get調査員郵便番号() {
        return entity.getChosainYubinNo();
    }

    /**
     * 調査員住所を返します。
     *
     * @return 調査員住所
     */
    public AtenaJusho get調査員住所() {
        return entity.getChosainJusho();
    }

    /**
     * 調査員電話番号を返します。
     *
     * @return 調査員電話番号
     */
    public TelNo get調査員電話番号() {
        return entity.getChosainTelNo();
    }

    /**
     * 調査員FAX番号を返します。
     *
     * @return 調査員FAX番号
     */
    public TelNo get調査員FAX番号() {
        return entity.getChosainFaxNo();
    }

    /**
     * 所属機関名称を返します。
     *
     * @return 所属機関名称
     */
    public RString get所属機関名称() {
        return entity.getShozokuKikanName();
    }

}

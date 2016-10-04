/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.NinnteiChousairaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼項目を管理するクラスです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
public class NinnteiChousairaiBusiness {

    private final NinnteiChousairaiEntity entity;

    /**
     * 認定調査依頼項目を返します。
     *
     * @param entity NinnteiChousairaiEntity
     */
    public NinnteiChousairaiBusiness(NinnteiChousairaiEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString getNinteichosaItakusakiCode() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString getJigyoshaMeisho() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 割付地区を返します。
     *
     * @return 割付地区
     */
    public ChikuCode getWaritsukeChiku() {
        return entity.getWaritsukeChiku();
    }

    /**
     * 割付定員を返します。
     *
     * @return 割付定員
     */
    public int getWaritsukeTeiin() {
        return entity.getWaritsukeTeiin();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString getJusho() {
        return entity.getJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return entity.getTelNo();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * 機関の区分を返します。
     *
     * @return 機関の区分
     */
    public RString getKikanKubun() {
        return entity.getKikanKubun();
    }

    /**
     * 割付済み件数を返します。
     *
     * @return 割付済み件数
     */
    public int getWaritsukesumiKensu() {
        return entity.getWaritsukesumiKensu();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString getNinteiChosainNo() {
        return entity.getNinteiChosainNo();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString getChosainShimei() {
        return entity.getChosainShimei();
    }

    /**
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    public RString getChosainKanaShimei() {
        return entity.getChosainKanaShimei();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString getSeibetsu() {
        return entity.getSeibetsu();
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public RString getChikuCode() {
        return entity.getChikuCode();
    }

    /**
     * 調査員資格を返します。
     *
     * @return 調査員資格
     */
    public RString getChosainShikaku() {
        return entity.getChosainShikaku();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString getShichosonMeisho() {
        return entity.getShichosonMeisho();
    }

    /**
     * 調査可能人数／月を返します。
     *
     * @return 調査可能人数／月
     */
    public int getChosaKanoNinzuPerMonth() {
        return entity.getChosaKanoNinzuPerMonth();
    }

}

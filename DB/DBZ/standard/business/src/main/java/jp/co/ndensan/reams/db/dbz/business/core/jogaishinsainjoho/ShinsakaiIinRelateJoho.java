/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.jogaishinsainjoho.ShinsakaiIinJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会委員情報のRelateBusinessクラス。
 *
 * @reamsid_L DBZ-1300-040 dongyabin
 */
public class ShinsakaiIinRelateJoho {

    private final ShinsakaiIinJohoRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 審査会委員情報のRelateEntityクラス。
     */
    public ShinsakaiIinRelateJoho(ShinsakaiIinJohoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護認定審査会委員コードを取得します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString get介護認定審査会委員コード() {
        return entity.getShinsakaiIinCode();
    }

    /**
     * 介護認定審査会委員開始年月日を取得します。
     *
     * @return 介護認定審査会委員開始年月日
     */
    public FlexibleDate get介護認定審査会委員開始年月日() {
        return entity.getShinsakaiIinKaishiYMD();
    }

    /**
     * 介護認定審査会委員終了年月日を取得します。
     *
     * @return 介護認定審査会委員終了年月日
     */
    public FlexibleDate get介護認定審査会委員終了年月日() {
        return entity.getShinsakaiIinShuryoYMD();
    }

    /**
     * 介護認定審査会委員氏名を取得します。
     *
     * @return 介護認定審査会委員氏名
     */
    public AtenaMeisho get介護認定審査会委員氏名() {
        return entity.getShinsakaiIinShimei();
    }

    /**
     * 介護認定審査会委員氏名カナを取得します。
     *
     * @return 介護認定審査会委員氏名カナ
     */
    public AtenaKanaMeisho get介護認定審査会委員氏名カナ() {
        return entity.getShinsakaiIinKanaShimei();
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
     * 介護認定審査員資格コードを取得します。
     *
     * @return 介護認定審査員資格コード
     */
    public Code get介護認定審査員資格コード() {
        return entity.getShinsakaiIinShikakuCode();
    }

    /**
     * 審査員郵送区分を取得します。
     *
     * @return 審査員郵送区分
     */
    public RString get審査員郵送区分() {
        return entity.getShinsainYusoKubun();
    }

    /**
     * 担当地区コードを取得します。
     *
     * @return 担当地区コード
     */
    public ChikuCode get担当地区コード() {
        return entity.getTantoChikuCode();
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

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 備考を取得します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * 廃止フラグを取得します。
     *
     * @return 廃止フラグ
     */
    public boolean is廃止フラグ() {
        return entity.isHaishiFlag();
    }

    /**
     * 廃止年月日を取得します。
     *
     * @return 廃止年月日
     */
    public FlexibleDate get廃止年月日() {
        return entity.getHaishiYMD();
    }

    /**
     * 連番を取得します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRemban();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 主治医医療機関コードを取得します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 主治医コードを取得します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * t認定調査委託先コードを取得します。
     *
     * @return t認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 認定調査員コードを取得します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainNo();
    }

    /**
     * その他機関コードを取得します。
     *
     * @return その他機関コード
     */
    public RString getその他機関コード() {
        return entity.getSonotaKikanCode();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 除外対象審査会委員コードを取得します。
     *
     * @return 除外対象審査会委員コード
     */
    public RString get除外対象審査会委員コード() {
        return entity.getJogaiTaishoShinsakaiIinCode();
    }
}

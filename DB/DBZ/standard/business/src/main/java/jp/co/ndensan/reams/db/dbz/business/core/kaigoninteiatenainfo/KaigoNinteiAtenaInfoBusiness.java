/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kaigoninteiatenainfo;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.kaigoninteiatenainfo.KaigoNinteiAtenaInfoRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定宛名情報を取得クラスです。
 */
public class KaigoNinteiAtenaInfoBusiness {

    private final KaigoNinteiAtenaInfoRelateEntity kaigoEntity;

    /**
     * 介護認定宛名情報項目を返します。
     *
     * @param kaigoEntity
     */
    public KaigoNinteiAtenaInfoBusiness(KaigoNinteiAtenaInfoRelateEntity kaigoEntity) {
        this.kaigoEntity = kaigoEntity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return kaigoEntity.getShinseishoKanriNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return kaigoEntity.getShikibetsuCode();
    }

    /**
     * 住民種別コードを返します。
     *
     * @return 住民種別コード
     */
    public RString get住民種別コード() {
        return kaigoEntity.getFt200Entity().getJuminShubetsuCode();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get宛名PSM識別コード() {
        return kaigoEntity.getFt200Entity().getShikibetsuCode();
    }

    /**
     * 個人番号を返します。
     *
     * @return 個人番号
     */
    public KojinNo get個人番号() {
        return kaigoEntity.getFt200Entity().getKojinNo();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return kaigoEntity.getFt200Entity().getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return kaigoEntity.getFt200Entity().getJusho();
    }

    /**
     * 連絡先を返します。
     *
     * @return 連絡先
     */
    public TelNo get連絡先() {
        return kaigoEntity.getFt200Entity().getRenrakusaki1();
    }

    /**
     * 行政区名を返します。
     *
     * @return 行政区名
     */
    public RString get行政区名() {
        return kaigoEntity.getFt200Entity().getGyoseikuName();
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return kaigoEntity.getFt200Entity().getSetaiCode();
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return kaigoEntity.getHihokenshaName();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return kaigoEntity.getSeinengappiYMD();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        return kaigoEntity.getAge();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return kaigoEntity.getSeibetsu();
    }
}

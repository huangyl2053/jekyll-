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
 * 介護認定宛名情報を取得クラスです。
 *
 * @reamsid_L DBZ-1300-050 lizhuoxuan
 */
public class KaigoNinteiAtenaInfoBusiness {

    private final KaigoNinteiAtenaInfoRelateEntity kaigoEntity;

    /**
     * 介護認定宛名情報項目を返します。
     *
     * @param kaigoEntity KaigoNinteiAtenaInfoRelateEntity
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
        if (kaigoEntity.getFt200Entity() != null) {
            return kaigoEntity.getFt200Entity().getJuminShubetsuCode();
        }
        return RString.EMPTY;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get宛名PSM識別コード() {
        if (kaigoEntity.getFt200Entity() != null) {
            return kaigoEntity.getFt200Entity().getShikibetsuCode();
        }
        return ShikibetsuCode.EMPTY;
    }

    /**
     * 個人番号を返します。
     *
     * @return 個人番号
     */
    public KojinNo get個人番号() {
        if (kaigoEntity.getFt200Entity() != null) {
            return kaigoEntity.getFt200Entity().getKojinNo();
        }
        return KojinNo.EMPTY;
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        if (kaigoEntity.getFt200Entity() != null) {
            return kaigoEntity.getFt200Entity().getYubinNo();
        }
        return YubinNo.EMPTY;
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        if (kaigoEntity.getFt200Entity() != null) {
            return kaigoEntity.getFt200Entity().getJusho();
        }
        return AtenaJusho.EMPTY;
    }

    /**
     * 連絡先を返します。
     *
     * @return 連絡先
     */
    public TelNo get連絡先() {
        if (kaigoEntity.getFt200Entity() != null) {
            return kaigoEntity.getFt200Entity().getRenrakusaki1();
        }
        return TelNo.EMPTY;
    }

    /**
     * 行政区名を返します。
     *
     * @return 行政区名
     */
    public RString get行政区名() {
        if (kaigoEntity.getFt200Entity() != null) {
            return kaigoEntity.getFt200Entity().getGyoseikuName();
        }
        return RString.EMPTY;
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        if (kaigoEntity.getFt200Entity() != null) {
            return kaigoEntity.getFt200Entity().getSetaiCode();
        }
        return SetaiCode.EMPTY;
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

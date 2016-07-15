/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyokobetsukoikiunyo;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsu.KaigojuminhyokobetsuEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域運用抽出期間情報を管理するビジネスです。
 *
 * @reamsid_L DBU-0550-040 zhangzhiming
 */
public class KaigoJuminhyoKobetsuKoikiunyo {

    private final KaigojuminhyokobetsuEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 広域運用抽出期間情報Entity
     */
    public KaigoJuminhyoKobetsuKoikiunyo(KaigojuminhyokobetsuEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村識別IDを取得します。
     *
     * @return 市町村識別ID
     */
    public RString getShichosonShokibetsuID() {
        return entity.getShichosonShokibetsuID();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString getShichosonMeisho() {
        return entity.getShichosonMeisho();
    }

    /**
     * 対象終了日時を取得します。
     *
     * @return 対象終了日時
     */
    public YMDHMS getTaishoShuryoTimestamp() {
        return entity.getTaishoShuryoTimestamp();
    }

    /**
     * 対象開始日時を取得します。
     *
     * @return 対象開始日時
     */
    public YMDHMS getTaishoKaishiTimestamp() {
        return entity.getTaishoKaishiTimestamp();
    }
}

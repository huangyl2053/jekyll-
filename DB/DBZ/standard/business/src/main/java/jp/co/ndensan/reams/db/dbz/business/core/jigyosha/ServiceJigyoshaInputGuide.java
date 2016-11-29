/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.jigyosha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.core.kaigojigyoshano.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ServiceJigyoshaInputGuideRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者施設オブジェクトの項目定義クラスです。
 *
 * @reamsid_L DBA-0140-010 houtianpeng
 */
public class ServiceJigyoshaInputGuide implements Serializable {

    private static final long serialVersionUID = -6323018880264468128L;

    private final ServiceJigyoshaInputGuideRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 介護事業者施設Entity
     */
    public ServiceJigyoshaInputGuide(ServiceJigyoshaInputGuideRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号
     */
    public KaigoJigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 有効開始日を取得します。
     *
     * @return 有効開始日
     */
    public FlexibleDate get有効開始日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了日を取得します。
     *
     * @return 有効終了日
     */
    public FlexibleDate get有効終了日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return entity.getJigyoshaName();
    }

    /**
     * 事業者名称カナを取得します。
     *
     * @return 事業者名称カナ
     */
    public AtenaKanaMeisho get事業者名称カナ() {
        return entity.getJigyoshaNameKana();
    }

    /**
     * サービス種類略称を取得します。
     *
     * @return サービス種類略称
     */
    public RString getサービス種類略称() {
        return entity.getServiceShuruiRyakusho();
    }

    /**
     * 事業者住所カナを取得します。
     *
     * @return 事業者住所カナ
     */
    public RString get事業者住所カナ() {
        return entity.getJigyoshaKanaAddress();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get介護除外住所地特例対象施設_事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 事業者名称カナを取得します。
     *
     * @return 事業者名称カナ
     */
    public AtenaKanaMeisho get介護除外住所地特例対象施設_事業者名称カナ() {
        return entity.getJigyoshaKanaMeisho();
    }

    /**
     * 事業者住所カナを取得します。
     *
     * @return 事業者住所カナ
     */
    public RString get介護除外住所地特例対象施設_事業者住所カナ() {
        return entity.getJigyoshaKanaJusho();
    }

    /**
     * 事業者住所を取得します。
     *
     * @return 事業者住所
     */
    public RString get介護除外住所地特例対象施設_事業者住所() {
        return entity.getJigyoshaJusho();
    }

    /**
     * 事業者住所を取得します。
     *
     * @return 事業者住所
     */
    public AtenaJusho get介護事業者_事業者住所() {
        return entity.getJigyoshaAddress();
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
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public RString getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.EigyoKeitai;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任事業者が持つ契約事業者情報のクラスです。
 *
 * @author N3317 塚田 萌
 */
public class KeiyakuJigyosha {

    private final JigyoshaNo 事業者番号;
    private final IHojin 法人;
    private final TelNo 事業者FAX番号;
    private final EigyoKeitai 営業形態;
    private final RString 送付先部署;
    private final IKoza 口座;
    //TODO ISofusakiが見つかったら対応
    //private final ISofusaki 送付先;

    /**
     * コンストラクタです。
     *
     * @param 事業者番号
     * @param 法人
     * @param 事業者FAX番号
     * @param 営業形態
     * @param 送付先部署
     * @param 口座
     */
    public KeiyakuJigyosha(JigyoshaNo 事業者番号, IHojin 法人, TelNo 事業者FAX番号,
            EigyoKeitai 営業形態, RString 送付先部署, IKoza 口座) {
        this.事業者番号 = 事業者番号;
        this.法人 = requireNonNull(法人, Messages.E00001.replace("法人").getMessage());
        this.事業者FAX番号 = 事業者FAX番号;
        this.営業形態 = 営業形態;
        this.送付先部署 = 送付先部署;
        this.口座 = requireNonNull(口座, Messages.E00001.replace("口座").getMessage());
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return 事業者番号;
    }

    /**
     * 法人を返します。
     *
     * @return 法人
     */
    public IHojin get法人() {
        return 法人;
    }

    /**
     * 事業者FAX番号を返します。
     *
     * @return 事業者FAX番号
     */
    public TelNo get事業者FAX番号() {
        return 事業者FAX番号;
    }

    /**
     * 営業形態を返します。
     *
     * @return 営業形態
     */
    public EigyoKeitai get営業形態() {
        return 営業形態;
    }

    /**
     * 送付先部署を返します。
     *
     * @return 送付先部署
     */
    public RString get送付先部署() {
        return 送付先部署;
    }

    /**
     * 口座を返します。
     *
     * @return 口座
     */
    public IKoza get口座() {
        return 口座;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio;

import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護事業者・施設管理のBusinessクラスです。
 *
 * @reamsid_L DBA-0340-010 wanghui
 */
public class KaigoJogaiTokureiBusiness {

    private final KaigoJogaiTokureiRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 介護事業者・施設管理Entity
     */
    public KaigoJogaiTokureiBusiness(KaigoJogaiTokureiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 有効開始日を取得します。
     *
     * @return 有効開始日
     */
    public RString get有効開始日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了日を取得します。
     *
     * @return 有効終了日
     */
    public RString get有効終了日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaName();
    }

    /**
     * 管理者氏名を取得します。
     *
     * @return 管理者氏名
     */
    public RString get管理者氏名() {
        return entity.getKanrishaName();
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

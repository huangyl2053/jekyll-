/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio;

import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.JigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護事業者・ービス一覧表示情報のBusinessクラスです。
 *
 * @reamsid_L DBA-0340-010 lijia
 */
public class ServiceItiranHyojiJohoBusiness {

    private final JigyoshaShiteiServiceEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 介護事業者・施設管理Entity
     */
    public ServiceItiranHyojiJohoBusiness(JigyoshaShiteiServiceEntity entity) {
        this.entity = entity;
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
     * 管理者氏名を取得します。
     *
     * @return 管理者氏名
     */
    public AtenaMeisho get管理者氏名() {
        return entity.getKanrishaName();
    }

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
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
     * isDeletedのgetメソッドです。
     * 
     * @return isDeleted
     */
    public boolean get削除フラグ() {
        return entity.isDeleted();
    }

}

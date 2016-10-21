/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jigyoshaservice.JigyoshaServiceJoho;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.JigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
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
    @SuppressWarnings("PMD.BooleanGetMethodName")
    public boolean get削除フラグ() {
        return entity.isDeleted();
    }

    /**
     * 介護事業者指定サービスのクラスを元に、表示用クラスを作成します。
     *
     * @param service 介護事業者指定サービス
     * @param serviceTypeList サービス種類一覧。nullや空のListを渡すとサービス略称が設定されません。
     * @return 表示用クラス
     */
    public static ServiceItiranHyojiJohoBusiness create(KaigoJigyoshaShiteiService service, List<JigyoshaServiceJoho> serviceTypeList) {

        RString 合致サービス種類略称 = RString.EMPTY;
        if (serviceTypeList != null) {
            for (JigyoshaServiceJoho サービス種類 : serviceTypeList) {
                if (サービス種類.getサービス種類コード().equals(service.getサービス種類コード())) {
                    合致サービス種類略称 = サービス種類.getサービス種類略称();
                }
            }
        }
        ServiceItiranHyojiJohoBusiness business;
        JigyoshaShiteiServiceEntity entity = new JigyoshaShiteiServiceEntity();
        entity.setDeleted(!service.hasChanged() && service.toEntity().getIsDeleted());
        entity.setJigyoshaName(service.get事業者名称());
        entity.setKanrishaName(service.get管理者氏名());
        entity.setServiceShuruiCode(service.getサービス種類コード());
        entity.setServiceShuruiRyakusho(合致サービス種類略称);
        entity.setYukoKaishiYMD(service.get登録開始日());
        entity.setYukoShuryoYMD(service.get登録終了日());

        return new ServiceItiranHyojiJohoBusiness(entity);
    }

}

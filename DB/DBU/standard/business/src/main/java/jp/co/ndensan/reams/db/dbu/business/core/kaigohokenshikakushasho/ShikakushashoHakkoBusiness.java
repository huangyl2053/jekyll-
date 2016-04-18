/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigohokenshikakushasho.KyufuseigenDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigohokenshikakushasho.NyushoShisetsuDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigohokenshikakushasho.ShuruiShikyuGendoKizyunngakuEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.ShienJigyoshaEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.ShikakushashoHakkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格者証発行のビジネスです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
public class ShikakushashoHakkoBusiness {

    private final ShikakushashoHakkoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 資格者証発行のエンティティ
     */
    public ShikakushashoHakkoBusiness(ShikakushashoHakkoEntity entity) {

        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("資格者証発行のエンティティ"));
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.getHokenshaNo();
    }

    /**
     * 保険者名称を取得します。
     *
     * @return 保険者名称
     */
    public RString get保険者名称() {
        return entity.getHokenshaName();
    }

    /**
     * 有効期限を取得します。
     *
     * @return 有効期限
     */
    public RString get有効期限() {
        return entity.getYukoKigen();
    }

    /**
     * 被保番号を取得します。
     *
     * @return 被保番号
     */
    public RString get被保番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 交付日を取得します。
     *
     * @return 交付日
     */
    public RString get交付日() {
        return entity.getKofuYMD();
    }

    /**
     * 介護状態を取得します。
     *
     * @return 介護状態
     */
    public RString get介護状態() {
        return entity.getYokaigoJotai();
    }

    /**
     * 認定日を取得します。
     *
     * @return 認定日
     */
    public RString get認定日() {
        return entity.getNinteiYMD();
    }

    /**
     * 有効期間の開始日付を取得します。
     *
     * @return 有効期間の開始日付
     */
    public RString get有効期間の開始日付() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効期間の終了日付を取得します。
     *
     * @return 有効期間の終了日付
     */
    public RString get有効期間の終了日付() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 区分支給限度額の有効期間の開始日付を取得します。
     *
     * @return 区分支給限度額の有効期間の開始日付
     */
    public RString get区分支給限度額の有効期間の開始日付() {
        return entity.getKubunShikyuYukoKaishiYMD();
    }

    /**
     * 区分支給限度額の有効期間の終了日付を取得します。
     *
     * @return 区分支給限度額の有効期間の終了日付
     */
    public RString get区分支給限度額の有効期間の終了日付() {
        return entity.getKubunShikyuYukoShuryoYMD();
    }

    /**
     * 区分支給限度額の基準額を取得します。
     *
     * @return 区分支給限度額の基準額
     */
    public RString get区分支給限度額の基準額() {
        return entity.getKubunShikyuKizyunngaku();
    }

    /**
     * うち種類支給限度基準額の情報を取得します。
     *
     * @return うち種類支給限度基準額の情報
     */
    public List<ShuruiShikyuGendoKizyunngakuEntity> getうち種類支給限度基準額の情報() {
        return entity.getShikyuGendoKizyungakuList();
    }

    /**
     * 認定審査会の意見及びサービスの種類の指定を取得します。
     *
     * @return 認定審査会の意見及びサービスの種類の指定
     */
    public RString get認定審査会の意見及びサービスの種類の指定() {
        return entity.getServiceShitei();
    }

    /**
     * 給付制限の情報を取得します。
     *
     * @return 給付制限の情報
     */
    public List<KyufuseigenDataEntity> get給付制限の情報() {
        return entity.getKyufuseigenDataList();
    }

    /**
     * 介護保険施設等の情報を取得します。
     *
     * @return 介護保険施設等の情報
     */
    public List<NyushoShisetsuDataEntity> get介護保険施設等の情報() {
        return entity.getNyushoShisetsuDataList();
    }

    /**
     * 支援事業者の情報を取得します。
     *
     * @return 支援事業者の情報
     */
    public List<ShienJigyoshaEntity> get支援事業者の情報() {
        return entity.getShienJigyoshaList();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return entity.getShikibetsuCode();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshosakuseiirai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.WaritsukeEntity;

/**
 * 主治医意見書のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public interface IShujiiIkenshoSakuseiIraiMapper {

    /**
     * 割付済み申請者一覧を取得します。
     * 
     * @param param 主治医意見書作成依頼情報を特定するためのMyBatis用パラメータクラスです。
     * @return 割付済み申請者一覧Entityクラスです。
     */
    List<WaritsukeEntity> get割付済み申請者情報(ShujiiIkenshoSakuseiIraiParameter param);
    
    /**
     * 未割付申請者一覧を取得します。
     * @param param 主治医意見書作成依頼情報を特定するためのMyBatis用パラメータクラスです。
     * @return 割付済み申請者一覧Entityクラスです。
     */
    List<WaritsukeEntity> get未割付申請者情報(ShujiiIkenshoSakuseiIraiParameter param);

    /**
     * 宛名情報を取得します。
     *
     * @param param 宛名情報のMyBatis用パラメータ
     * @return 宛名情報Entity
     */
    ShujiiIraiAtenaJohoRelateEntity get宛名情報(ShujiiIraiAtenaJohoParameter param);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenshinseishotaishohaaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku.KousinSinseiTaishougaishaJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.KousinSinseiTaishougaishaJohoEntity;

/**
 *
 * 更新申請対象外者特定作成 Mapper
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
public interface IKousinSinseiTaishougaishaJohoMapper {

    /**
     * 世帯員把握入力一時テーブルをクリアするメソッドです。
     *
     */
    void clear世帯員把握入力一時テーブル();

    /**
     * 世帯員所得情報一時テーブルをクリアするメソッドです。
     *
     */
    void clear世帯員所得情報一時テーブル();

    /**
     * 減免減額対象者判定用根拠作成対象者一時テーブルをクリアするメソッドです。
     *
     */
    void clear減免減額対象者判定用根拠作成対象者一時テーブル();

    /**
     * 減免減額対象者判定用根拠一時テーブルをクリアするメソッドです。
     *
     */
    void clear減免減額対象者判定用根拠一時テーブル();

    /**
     * 世帯員所得情報一時テーブルを削除する。
     *
     */
    void delete世帯員所得情報一時テーブル();

    /**
     * 更新申請対象外者情報_負担限度額認定情報の抽出メソッドです。
     *
     * @param parameter ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter
     *
     * @return List<KousinSinseiTaishougaishaJohoEntity> 更新申請対象外者情報
     */
    List<KousinSinseiTaishougaishaJohoEntity> get更新申請対象外者情報_負担限度額認定(KousinSinseiTaishougaishaJohoMyBatisParameter parameter);

    /**
     * 更新申請対象外者情報_利用者負担額減額情報の抽出メソッドです。
     *
     * @param parameter ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter
     *
     * @return List<KousinSinseiTaishougaishaJohoEntity> 更新申請対象外者情報
     */
    List<KousinSinseiTaishougaishaJohoEntity> get更新申請対象外者情報_利用者負担額減額(KousinSinseiTaishougaishaJohoMyBatisParameter parameter);

    /**
     * 更新申請対象外者情報_訪問介護利用者負担額減額情報の抽出メソッドです。
     *
     * @param parameter ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter
     *
     * @return List<KousinSinseiTaishougaishaJohoEntity> 更新申請対象外者情報
     */
    List<KousinSinseiTaishougaishaJohoEntity> get更新申請対象外者情報_訪問介護利用者負担額減額(KousinSinseiTaishougaishaJohoMyBatisParameter parameter);

    /**
     * 新申請対象外者情報_社会福祉法人等利用者負担軽減情報の抽出メソッドです。
     *
     * @param parameter ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter
     *
     * @return List<KousinSinseiTaishougaishaJohoEntity> 更新申請対象外者情報
     */
    List<KousinSinseiTaishougaishaJohoEntity> get更新申請対象外者情報_社会福祉法人等利用者負担軽減(KousinSinseiTaishougaishaJohoMyBatisParameter parameter);
}

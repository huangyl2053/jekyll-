/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput.GaikyoChosaDataMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsataishodataoutput.ShinsaTaishoDataOutPutMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaData5207_08_09_10RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.GaikyoChosaDataZenkaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.KihonChosaKomokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.SaikaiObjectOutPutEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定審査会割当委員情報出力（モバイル）のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
public interface IShinsaTaishoDataOutPutMapper {

    /**
     * 介護認定審査会情報を取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）のMapperパラメータ
     * @return List<ShinsakaiJohoRelateEntity>
     */
    List<ShinsakaiJohoRelateEntity> get介護認定審査会情報(ShinsaTaishoDataOutPutMybatisParameter param);

    /**
     * 介護認定審査会委員情報を取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）のMapperパラメータ
     * @return List<ShinsakaiIinJohoRelateEntity>
     */
    List<ShinsakaiIinJohoRelateEntity> get介護認定審査会委員情報(ShinsaTaishoDataOutPutMybatisParameter param);

    /**
     * 基本調査項目データを取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）のMapperパラメータ
     * @return List<KihonChosaKomokuDataRelateEntity>
     */
    List<KihonChosaKomokuDataRelateEntity> get基本調査項目データ(ShinsaTaishoDataOutPutMybatisParameter param);

    /**
     * 概況調査データを取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）のMapperパラメータ
     * @return List<KihonChosaKomokuDataRelateEntity>
     */
    List<GaikyoChosaDataRelateEntity> get概況調査データ(ShinsaTaishoDataOutPutMybatisParameter param);

    /**
     * 申請書管理番号と認定調査依頼履歴番号に紐付く概況調査関連データ(DbT5207、DbT5208、DbT5209、DbT5210)を取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）における概況調査関連データのMapperパラメータ
     * @return List<GaikyoChosaData5207_08_09_10RelateEntity>
     */
    GaikyoChosaData5207_08_09_10RelateEntity get概況調査データサービスの状況等(GaikyoChosaDataMybatisParameter param);

    /**
     * 申請書管理番号(前回番号、前々回番号指定による)に紐付く概況調査データを取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）における概況調査関連データのMapperパラメータ
     * @return GaikyoChosaDataZenkaiJohoRelateEntity
     */
    GaikyoChosaDataZenkaiJohoRelateEntity get概況調査データ前回情報(GaikyoChosaDataMybatisParameter param);

    /**
     * 申請書管理番号紐付く要介護認定主治医意見書意見項目のリストを取得します。
     *
     * @param param 認定審査依頼IF作成（モバイル）における概況調査関連データのMapperパラメータ
     * @return List<DbT5304ShujiiIkenshoIkenItemEntity>
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> get要介護認定主治医意見書意見項目(GaikyoChosaDataMybatisParameter param);

    /**
     * 審査対象データを取得します。
     *
     * @param kaisaiBangou 審査対象データを取得のパラメータ
     * @return NijihanteiKekkaTorokuMobileRelateEntity
     */
    SaikaiObjectOutPutEntity get審査対象(RString kaisaiBangou);

}

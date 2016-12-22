package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.taisyosyajidowaritsuke;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeKensakuParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者自動割付のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1350-040 wangxiaodong
 */
public interface ITaisyosyaJidoWaritsukeRelateMapper {

    /**
     * 対象者を取得します。
     *
     * @param parameter 対象者自動割付のMybatisパラメータ
     * @return List<TaisyosyaJidoWaritsukeEntity>
     */
    List<TaisyosyaJidoWaritsukeEntity> selectTaisyosya(TaisyosyaJidoWaritsukeKensakuParameter parameter);

    /**
     * 介護認定審査会開催予定情報を取得します。
     *
     * @param shinsakaiKaisaiNo 開催番号
     * @return 介護認定審査会開催予定情報
     */
    DbT5501ShinsakaiKaisaiYoteiJohoEntity selectYoteiJohoForUpdate(RString shinsakaiKaisaiNo);

    /**
     * 要介護認定申請情報を取得します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return 要介護認定申請情報エンティティ
     */
    DbT5101NinteiShinseiJohoEntity selectNinteiShinseiJohoByKey(RString shinseishoKanriNo);

    /**
     * 介護認定審査会割当委員情報件数を取得します。
     *
     * @param parameter 対象者自動割付のMybatisパラメータ
     * @return 介護認定審査会割当委員情報件数
     */
    int selectCountShinsakaiWariateIinJoho(TaisyosyaJidoWaritsukeMybatisParameter parameter);

    /**
     * 審査会委員除外情報件数を取得します。
     *
     * @param parameter 対象者自動割付のMybatisパラメータ
     * @return 審査会委員除外情報件数
     */
    int selectCountShinsakaiIinJogaiJoho(TaisyosyaJidoWaritsukeMybatisParameter parameter);

    /**
     * 割付済の審査順を開催番号で取得します。
     *
     * @param shinsakaiKaisaiNo 開催番号
     * @return 割付済の審査順
     */
    int selectMaxShinsakaiOrder(RString shinsakaiKaisaiNo);

    /**
     * 介護認定審査会割付情報を格納します。
     *
     * @param entity 介護認定審査会割当情報エンティティ
     * @return insert 件数
     */
    int insertDbT5502ShinsakaiWariateJoho(DbT5502ShinsakaiWariateJohoEntity entity);

    /**
     * 介護認定審査会割付情報を格納します。
     *
     * @param entity 介護認定審査会開催予定情報エンティティ
     * @return update 件数
     */
    int updateDbT5501ShinsakaiKaisaiYoteiJoho(DbT5501ShinsakaiKaisaiYoteiJohoEntity entity);

}

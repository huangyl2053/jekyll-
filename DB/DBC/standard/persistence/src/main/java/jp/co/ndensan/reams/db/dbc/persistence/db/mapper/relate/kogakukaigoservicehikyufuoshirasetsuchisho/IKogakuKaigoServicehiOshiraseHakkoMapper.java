/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufuoshirasetsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.HihokenshaDaichoShinseiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.JikyoKogakuKaigoServiceHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServiceHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempRelateEntity;

/**
 * 高額サービス費給付お知らせ通知書作成のマッピングクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public interface IKogakuKaigoServicehiOshiraseHakkoMapper {

    /**
     * 高額介護サービス費情報を取得します。
     *
     * @param param 検索パラメータ
     * @return 高額介護サービス費情報
     */
    List<KogakuKaigoServiceHiRelateEntity> get高額介護サービス費情報(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 事業高額介護サービス費情報を取得します。
     *
     * @param param 検索パラメータ
     * @return 事業高額介護サービス費情報
     */
    List<JikyoKogakuKaigoServiceHiRelateEntity> get事業高額介護サービス費情報(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 被保険者台帳データ(申請情報)を取得します。
     *
     * @return 被保険者台帳データ
     */
    List<HihokenshaDaichoShinseiRelateEntity> get被保険者台帳データFor申請情報();

    /**
     * 自動償還対象(高額介護サービス費)を取得します。
     *
     * @param param 検索パラメータ
     * @return 自動償還対象
     */
    List<KogakuKaigoServiceHiRelateEntity> get自動償還対象For高額介護サービス費(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 自動償還対象(事業高額介護サービス費)を取得します。
     *
     * @param param 検索パラメータ
     * @return 自動償還対象
     */
    List<JikyoKogakuKaigoServiceHiRelateEntity> get自動償還対象For事業高額介護サービス費(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 被保険者台帳データ(申請情報償還)を取得します。
     *
     * @return 被保険者台帳データ
     */
    List<HihokenshaDaichoShinseiRelateEntity> get被保険者台帳データFor申請情報償還();

    /**
     * 処理対象外のデータ(申請情報償還一時)を削除します。
     */
    void 処理対象外のデータを削除();

    /**
     * 処理対象外のデータ(申請情報償還一時,受託あり)を削除します。
     *
     * @param param パラメータ
     */
    void 自動償還For受託ありの申請情報償還一時を削除(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 処理対象外のデータ(申請情報償還一時,受託ない)を削除します。
     *
     * @param param パラメータ
     */
    void 自動償還For受託ないの申請情報償還一時を削除(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 死亡者を自動償還を削除削除します。
     */
    void 死亡者を自動償還を削除();

    /**
     * 申請情報償還を取得します。
     *
     * @param param パラメータ
     * @return 申請情報償還
     */
    List<HihokenshaDaichoShinseiRelateEntity> get申請情報償還For申請情報(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 申請書発行一覧表データを取得します。
     *
     * @param param パラメータ
     * @return 申請書発行一覧表データ
     */
    List<ShinseiJohoChohyoTempEntity> get申請書発行一覧表(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 高額サービス費支給申請書のデータを取得します。
     *
     * @param param パラメータ
     * @return 高額サービス費支給申請書のデータ
     */
    List<ShinseiJohoChohyoTempEntity> get支給申請書データ(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 高額サービス費支給申請書のデータを取得します。
     *
     * @param param パラメータ
     * @return 高額サービス費支給申請書のデータ
     */
    List<ShinseiJohoChohyoTempRelateEntity> getお知らせ通知書データ(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 高額介護申請管理マスタのデータを取得します。
     *
     * @param param 検索パラメータ
     * @return 自動償還対象
     */
    List<KogakuKaigoServiceHiRelateEntity> get高額介護申請管理マスタのデータ(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 事業高額介護申請管理マスタのデータを取得します。
     *
     * @param param 検索パラメータ
     * @return 自動償還対象
     */
    List<JikyoKogakuKaigoServiceHiRelateEntity> get事業高額介護申請管理マスタのデータ(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 帳票出力用データを取得します。
     *
     * @param param 検索パラメータ
     * @return 帳票出力用データ
     */
    List<ShinseiJohoChohyoTempEntity> get帳票出力用データ(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 処理対象外のデータを取得します。
     *
     * @return 処理対象外のデータ
     */
    List<ShinseiJohoChohyoTempEntity> get処理対象外のデータ();

    /**
     * 処理対象外のデータを取得します。
     *
     * @param param 検索パラメータ
     * @return 処理対象外のデータ
     */
    List<ShinseiJohoChohyoTempEntity> get自動償還For受託ありの申請情報償還一時(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);

    /**
     * 処理対象外のデータを取得します。
     *
     * @return 処理対象外のデータ
     */
    List<ShinseiJohoChohyoTempEntity> get死亡者を自動償還();

    /**
     * 処理対象外のデータを取得します。
     *
     * @param param 検索パラメータ
     * @return 処理対象外のデータ
     */
    List<ShinseiJohoChohyoTempEntity> get自動償還For受託ないの申請情報償還一時(KogakuKaigoServicehiOshiraseHakkoMybatisParameter param);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.honnsanteifuka.HonnsanteiFukaMybatisParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannKihonSofuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannKooGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouChuukannShouKannTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouDetaToriGaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouSofuListTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.JukyushaDaichoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriKihonSofuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriKooGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.KyodoShoriShouKannTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.SofuEraRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin.SetaiYinEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 共同処理用受給者異動連絡票作成のMapperです
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public interface IHonnSanteiFukaMapper {

    /**
     * 共同処理用受給者異動基本送付データを取得する。
     *
     * @return 共同処理基本送付
     */
    List<DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity> select共同処理基本送付();

    /**
     * 共同処理用受給者異動償還送付データを取得する。
     *
     * @return 共同処理償還送付
     */
    List<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> select共同処理償還送付();

    /**
     * 共同処理用受給者異動高額送付データを取得する。
     *
     * @return 共同処理高額送付
     */
    List<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> select共同処理高額送付();

    /**
     * 共同処理用受給者異動基本送付一時データを取得する。
     *
     * @param paramter 共同処理用受給者異動
     * @return 共同処理基本送付一時
     */
    List<DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity> select共同処理基本送付一時(HonnsanteiFukaMybatisParamter paramter);

    /**
     * 共同処理用受給者異動償還送付一時データを取得する。
     *
     * @param paramter 共同処理用受給者異動
     * @return 共同処理償還送付一時
     */
    List<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> select共同処理償還送付一時(HonnsanteiFukaMybatisParamter paramter);

    /**
     * 共同処理用受給者異動高額送付一時データを取得する。
     *
     * @param paramter 共同処理用受給者異動
     * @return 共同処理高額送付一時
     */
    List<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> select共同処理高額送付一時(HonnsanteiFukaMybatisParamter paramter);

    /**
     * 受給者台帳情報を取得する。
     *
     * @param paramter 受給者台帳情報
     * @return 受給者台帳情報
     */
    List<JukyushaDaichoRelateEntity> select受給者台帳情報(HonnsanteiFukaMybatisParamter paramter);

    /**
     * 被保険者台帳情報を取得する。
     *
     * @param paramter 被保険者台帳情報
     * @return 被保険者台帳情報
     */
    List<DbT1001HihokenshaDaichoEntity> select被保険者台帳情報(HonnsanteiFukaMybatisParamter paramter);

    /**
     * 異動データ情報を取得する。
     *
     * @return 異動データ情報
     */
    List<IdouDetaToriGaTempEntity> select異動データ取得();

    /**
     * 異動中間基本送付一時のデータを削除する。
     *
     * @param paramter 異動データ取得トリガ
     * @return 異動データ情報
     */
    List<IdouChuukannKihonSofuTempEntity> update異動中間基本送付一時(HonnsanteiFukaMybatisParamter paramter);

    /**
     * 異動データ取得トリガ情報を取得する。
     *
     * @param paramter 異動データ情報
     * @return 送付エラー情報
     */
    List<SofuEraRelateEntity> select異動データ取得トリガ(List<IdouDetaToriGaTempEntity> paramter);

    /**
     * 送付エラー情報を取得する。
     *
     * @return 送付エラー情報
     */
    List<SofuEraRelateEntity> select送付エラーデータ();

    /**
     * 世帯員所得情報を取得する。
     *
     * @return 世帯員所得情報
     */
    List<SetaiYinEntity> select世帯員所得情報();

    /**
     * 共同処理用受給者異動基本送付一時テーブル情報を取得します。
     *
     * @return 共同処理用受給者異動基本送付情報
     */
    List<KyodoShoriKihonSofuTempEntity> select共同処理用受給者異動基本送付();

    /**
     * 異動中間基本送付一時テーブル情報を取得します。
     *
     * @return 異動中間基本送付情報
     */
    List<IdouChuukannKihonSofuTempEntity> select異動中間基本送付();

    /**
     * 送付対象リスト一時テーブル情報を取得します。
     *
     * @return 送付対象リスト情報
     */
    List<IdouSofuListTempEntity> select送付対象リスト();

    /**
     * 共同処理用受給者異動償還送付一時テーブル情報を取得します。
     *
     * @return 共同処理用受給者異動償還送付情報
     */
    List<KyodoShoriShouKannTempEntity> select共同処理用受給者異動償還送付();

    /**
     * 異動中間償還送付一時テーブル情報を取得します。
     *
     * @return 異動中間基本償還情報
     */
    List<IdouChuukannShouKannTempEntity> select異動中間償還送付();

    /**
     * 共同処理用受給者異動高額送付一時テーブル情報を取得します。
     *
     * @return 共同処理用受給者異動高額送付情報
     */
    List<KyodoShoriKooGakuTempEntity> select共同処理用受給者異動高額送付();

    /**
     * 異動中間高額送付一時テーブル情報を取得します。
     *
     * @return 異動中間高額送付情報
     */
    List<IdouChuukannKooGakuTempEntity> select異動中間高額送付();

    /**
     * 国保連インターフェース管理情報を取得します。
     *
     * @return 国保連情報
     */
    List<DbT3104KokuhorenInterfaceKanriEntity> select国保連インターフェース管理();

    /**
     * 構成市町村情報を取得します。
     *
     * @return 構成市町村情報
     */
    DbT7051KoseiShichosonMasterEntity select構成市町村情報();
}

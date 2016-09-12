/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenInterfaceUpdateMybaticParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu.HihokenshaAndDaichouAndAtenaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu.HihokenshaAndHenkanBangoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 国保連情報取込処理共通のMapperです<br>
 * 国保連インタフェース管理TBLを更新します。
 *
 * @reamsid_L DBC-0980-550 zhangrui
 */
public interface IKokuhorenKyoutsuuMapper {

    /**
     * selectbyKeyUndeleted
     *
     * @param parameter keyのパラメーター
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    List<DbT3104KokuhorenInterfaceKanriEntity> selectbyKeyUndeleted(KokuhorenInterfaceUpdateMybaticParameter parameter);

    /**
     * 処理結果リスト一時TBLを作成する。(テスト用)
     */
    void create処理結果リスト一時TBL();

    /**
     * 処理結果リスト一時テーブルの登録処理
     *
     * @param entity 処理結果リスト一時テーブルEntity
     * @return int 更新の結果
     */
    int insert処理結果リスト一時TBL(DbWT0002KokuhorenTorikomiErrorTempEntity entity);

    /**
     * 処理結果リスト一時テーブルに登録する前に一意判断
     *
     * @param entity 処理結果リスト一時テーブルEntity
     * @return int 0:登録できる 1:登録できない
     */
    int count処理結果ByPK(DbWT0002KokuhorenTorikomiErrorTempEntity entity);

    /**
     * 処理結果リスト一時TBLを取得する。
     *
     * @return 処理結果リスト一時TBLのエンティティ
     */
    List<DbWT0002KokuhorenTorikomiErrorTempEntity> select処理結果リスト一時TBL();

    /**
     * 一意の処理結果リストを取得する。
     *
     * @return 処理結果リスト一時TBLのエンティティ
     */
    DbWT0002KokuhorenTorikomiErrorTempEntity select処理結果リストUNIQUE();

    /**
     * 1.2 被保険者番号変換対象データを取得
     *
     * @param 変換基準日 FlexibleDate
     * @return 被保険者一時TBLのエンティティList
     */
    List<DbWT0001HihokenshaTempEntity> select被保険者番号変換対象(FlexibleDate 変換基準日);

    /**
     * すべての被保険者を取得(テスト用)
     *
     * @return 被保険者一時TBLのエンティティList
     */
    List<DbWT0001HihokenshaTempEntity> selectALL被保険者();

    /**
     * すべての過誤決定明細を取得(テスト用)
     *
     * @return 過誤決定明細のエンティティList
     */
    List<Map<String, Object>> selectALL過誤決定明細();

    /**
     * 1.3.2 旧市町村コードの更新
     *
     * @param 証記載保険者番号 HokenshaNo
     * @param 旧市町村コード LasdecCode
     */
    void update被保険者一時TBLWith旧市町村コード(@Param("証記載保険者番号") HokenshaNo 証記載保険者番号,
            @Param("旧市町村コード") LasdecCode 旧市町村コード);

    /**
     * 1.4.1 新被保険者番号対象データの取得
     *
     * @return HihokenshaAndHenkanBangoEntityのList
     */
    List<HihokenshaAndHenkanBangoEntity> select新被保険者番号();

    /**
     * 1.4.2 新被保険者番号（＝新旧被保険者番号変換テーブル．新番号）を変換被保険者番号に登録する
     *
     * @param 連番 int
     * @param 新番号 RString
     */
    void update被保険者一時TBLWith新被保険者番号(@Param("連番") int 連番, @Param("新番号") RString 新番号);

    /**
     * 1.4.3 番号変換不要なデータには被保険者番号⇒変換被保険者番号をセットする
     *
     * @param 変換基準日 FlexibleDate
     */
    void update被保険者一時TBLWith現被保険者番号(FlexibleDate 変換基準日);

    /**
     * 1.6 新旧被保険者番号変換不要の場合は、被保険者番号⇒変換被保険者番号にセットする
     *
     */
    void update被保険者番号WithEmpty変換被保険者番号();

    /**
     * 2.1 被保険者一時TBL．変換被保険者番号をもとに、被保険者および宛名情報を取得する
     *
     * @return HihokenshaAndDaichouAndAtenaEntityのList
     */
    List<HihokenshaAndDaichouAndAtenaEntity> select被保険者And宛名情報();

    /**
     * 2.2 処理2.1で取得した被保険者・宛名情報を被保険者一時TBLに登録する
     *
     * @param entity DbWT0001HihokenshaTempEntity
     */
    void update被保険者一時TBLWith被保険者宛名情報(DbWT0001HihokenshaTempEntity entity);

}

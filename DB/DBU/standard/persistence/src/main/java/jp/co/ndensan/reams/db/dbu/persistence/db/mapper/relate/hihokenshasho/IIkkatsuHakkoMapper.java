package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hihokenshasho.IkkatsuHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.SogoJigyoTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;

/**
 *
 * 被保険者証一括発行のマッパーインタフェースです。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
public interface IIkkatsuHakkoMapper {

    /**
     * 被保険者台帳の異動者情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getHihokenshaDaichoIdo(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 受給者台帳一時テーブルの作成。
     *
     * @param 検索条件 検索条件
     * @return 作成件数
     */
    int create受給者台帳Temp(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 総合事業対象者一時テーブルの作成。
     *
     * @param 検索条件 検索条件
     * @return 作成件数
     */
    int create総合事業対象者Temp(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 受給者台帳Tempのみの取得。
     *
     * @return List<SogoJigyoTaishoshaRelateEntity>
     */
    List<SogoJigyoTaishoshaRelateEntity> get受給者台帳Tempのみ();

    /**
     * 総合事業対象者Tempのみの取得。
     *
     * @return List<SogoJigyoTaishoshaRelateEntity>
     */
    List<SogoJigyoTaishoshaRelateEntity> get総合事業対象者Tempのみ();

    /**
     * 受給者台帳と総合事業対象者の両方Tempのみの取得。
     *
     * @return List<SogoJigyoTaishoshaRelateEntity>
     */
    List<SogoJigyoTaishoshaRelateEntity> get受給者台帳と総合事業対象者の両方();

    /**
     * 年齢到達予定者情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getNenreiTotatsuYotesha(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 一時テーブルの作成。
     *
     * @return 作成件数
     */
    int createTmpHihokenshasho_Ichi();

    /**
     * データを一時テーブルに登録します。
     *
     * @param ikkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity
     * @return 登録件数
     */
    int insertTmpHihokenshasho_Ichi(IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity);

    /**
     * データを一時テーブルに登録します。
     *
     * @return 更新件数
     */
    int updateShisetyuJotaiFlag();

    /**
     * 生年月日の値がない場合、対象情報の取得。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getTaishoJoho1();

    /**
     * 一時テーブルから生年月日の値があるデータを取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> get生年月日ある();

    /**
     * 生年月日の値がある場合、被保険者台帳管理にチェックします。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> get最新被保険者1();

    /**
     * 生年月日の値がある場合、被保険者台帳管理に再チェックします。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> get最新被保険者2();

    /**
     * 生年月日の値がある場合、適用除外者にチェックします。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> get最新適用除外者1();

    /**
     * 生年月日の値がある場合、適用除外者に再チェックします。
     *
     * @param 検索条件 検索条件
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> get最新適用除外者2(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 生年月日の値がある場合、他市町村住所地特例にチェックします。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> get最新他市町村住所地特例1();

    /**
     * 生年月日の値がある場合、他市町村住所地特例に再チェックします。
     *
     * @param 検索条件 検索条件
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> get最新他市町村住所地特例2(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 生年月日の値がある場合、転入保留対象者に取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> get転入保留対象者();

    /**
     * 画面で「再発行する」をチェックする場合、対象情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getCheckShoriDateKanri(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 一括発行する場合、対象情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getIkkatsuShoriDateKanri(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 対象外情報を削除します。
     *
     * @param 検索条件 検索条件
     * @return 削除件数
     */
    int deleteTmpHihoken(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 受給区分1更新します。
     *
     * @param 検索条件 検索条件
     * @return 更新件数
     */
    int updateJukyuKubun1(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 受給区分2更新します。
     *
     * @param 検索条件 検索条件
     * @return 更新件数
     */
    int updateJukyuKubun2(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 被保険者台帳の情報を取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getHihokenshaDaicho();

    /**
     * 被保険者台帳の情報を一時テーブルに更新します。
     *
     * @param entity entity
     * @return 更新件数
     */
    int updateTmp_Hihokenshasho(IkkatsuHakkoRelateEntity entity);

    /**
     * 介護保険施設入退所の情報を取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getKaigoHokenShisetsuNyutaisho();

    /**
     * 介護保険施設入退所の情報を一時テーブルに更新します。
     *
     * @param entity entity
     * @return 更新件数
     */
    int updateTmp_KaigoHokenShisetsu(IkkatsuHakkoRelateEntity entity);

    /**
     * 受給者台帳の情報を取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getJukyushaDaicho();

    /**
     * 受給者台帳の情報取得を一時テーブルに更新します。
     *
     * @param entity entity
     * @return 更新件数
     */
    int updateTmp_JukyushaDaicho(IkkatsuHakkoRelateEntity entity);

    /**
     * 要介護認定結果情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getNinteiKekkaJoho(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 要介護認定結果情報の情報取得を一時テーブルに更新します。
     *
     * @param entity entity
     * @return 更新件数
     */
    int updateTmp_NinteiKekkaJoho(IkkatsuHakkoRelateEntity entity);

    /**
     * 支払方法変更情報を取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getShiharaiHohoHenko();

    /**
     * 支払方法変更の情報取得を一時テーブルに更新します。
     *
     * @param entity entity
     * @return 更新件数
     */
    int updateTmp_ShiharaiHohoHenko(IkkatsuHakkoRelateEntity entity);

    /**
     * 居宅給付計画届出情報を取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getKyotakuKeikakuTodokede();

    /**
     * 居宅給付計画事業者作成情報を取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getKyotakuKeikakuJigyoshaSakusei();

    /**
     * 居宅給付計画自己作成情報を取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getKyotakuKeikakuJikoSakusei();

    /**
     * 居宅給付計画届出の情報取得を一時テーブルに更新します。
     *
     * @param entity entity
     * @return 更新件数
     */
    int updateTmp_Kyotaku(IkkatsuHakkoRelateEntity entity);

    /**
     * 本人情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getHonninJoho(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 本人情報を一時テーブルに更新します。
     *
     * @param entity entity
     * @return 更新件数
     */
    int updateTmp_HonninJoho(IkkatsuHakkoRelateEntity entity);

    /**
     * 送付先情報を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getSofusakiJoho(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 送付先情報を一時テーブルに更新します。
     *
     * @param entity entity
     * @return 更新件数
     */
    int updateTmp_SofusakiJoho(IkkatsuHakkoRelateEntity entity);

    /**
     * 総合事業対象者の情報を取得します。
     *
     * @return List<SogoJigyoTaishoshaRelateEntity>
     */
    List<SogoJigyoTaishoshaRelateEntity> get総合事業対象者();

    /**
     * 総合事業対象者情報を一時テーブルに更新します。
     *
     * @param entity entity
     * @return 更新件数
     */
    int updateTmp総合事業対象者情報(SogoJigyoTaishoshaRelateEntity entity);

    /**
     * 被保険者証用データを取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getHihokenshayo();

    /**
     * 被保険者証一覧表用を取得します。
     *
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    List<IkkatsuHakkoRelateEntity> getHihokenshaIchiran();

    /**
     * 最新履歴番号を取得します。
     *
     * @param 検索条件 検索条件
     * @return {@link IkkatsuHakkoRelateEntity}
     */
    IkkatsuHakkoRelateEntity getSaishinrirekiNo(IkkatsuHakkoMybatisParameter 検索条件);

    /**
     * 同一被保険者番号の最大履歴番号を取得します。
     *
     * @param entity entity
     * @return 登録件数
     */
    int insertShoKofuKaishu(DbT7037ShoKofuKaishuEntity entity);

    /**
     * 処理日付管理マスタテーブルを更新します。
     *
     * @param entity entity
     * @return IkkatsuHakkoRelateEntity
     */
    int updateShoriDateKanri(DbT7022ShoriDateKanriEntity entity);

    /**
     * 一時テーブルを削除します。
     *
     * @return 削除件数
     */
    int dropTmpHihokenshasho_Ichi();

    /**
     * 一時テーブルを取得します。
     *
     * @return List<IkkatsuHakkoRelateEntity>
     */
    List<IkkatsuHakkoRelateEntity> getTmpHihokenshasho_Ichi();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji.CreateTaishoSetaiyinProcessMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji.InsTaishoSeitaiyinTempProcessMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji.UpdTaishoSeitaiyinTemp5ProcessMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.CreateTaishoSetaiyinEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.HihokenshaDaichoTempSixColumnEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.InsTaishoSeitaiyinTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.TaishoSetaiinEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.UpdTaishoSeitaiyinTemp1Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.UpdTaishoSeitaiyinTemp2Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.UpdTaishoSeitaiyinTemp3Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.UpdTaishoSeitaiyinTemp4Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetaiShotokuEntity;

/**
 * 基準収入額適用申請書_年次分作成のMapperです
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
public interface IKijunsyunyunenjiMapper {

    /**
     * 処理年度の対象者を取得する。
     *
     * @return 処理年度の対象者LのList
     */
    List<HihokenshaDaichoTempSixColumnEntity> select処理年度の対象者();

    /**
     * 被保険者番号指定の対象者を取得する。
     *
     * @return 被保険者番号指定度の対象者LのList
     */
    List<HihokenshaDaichoTempSixColumnEntity> select被保険者番号指定の対象者();

    /**
     * 世帯員所得情報一時テーブルをupdateする。
     */
    void update世帯員所得情報一時テーブル();

    /**
     * 被保険者番号指定の対象者を取得する。
     *
     * @return SetaiShotokuEntityLのList
     */
    List<SetaiShotokuEntity> delete世帯員所得情報一時テーブル();

    /**
     * 対象世帯員クラスTempに登録。
     *
     * @param para InsTaishoSeitaiyinTempProcessMybatisParameter
     * @return InsTaishoSeitaiyinTempEntityのList
     */
    List<InsTaishoSeitaiyinTempEntity> 対象世帯員クラスTempに登録(InsTaishoSeitaiyinTempProcessMybatisParameter para);

    /**
     * 対象世帯員クラスTempに更新1。
     *
     * @return UpdTaishoSeitaiyinTemp1EntityのList
     */
    List<UpdTaishoSeitaiyinTemp1Entity> 対象世帯員クラスTempに更新1();

    /**
     * 対象世帯員クラスTempに更新2。
     *
     * @return UpdTaishoSeitaiyinTemp2EntityのList
     */
    List<UpdTaishoSeitaiyinTemp2Entity> 対象世帯員クラスTempに更新2();

    /**
     * 対象世帯員クラスTempに更新3。
     *
     * @return UpdTaishoSeitaiyinTemp3EntityのList
     */
    List<UpdTaishoSeitaiyinTemp3Entity> 対象世帯員クラスTempに更新3();

    /**
     * 世帯員クラスTempをdeleteする。
     */
    void delete対象世帯員クラスTemp();

    /**
     * 世帯員所得情報一時テーブルをdeleteする。
     */
    void deleteAll世帯員所得情報一時テーブル();

    /**
     * 処理年度の対象者2を取得する。
     *
     * @return 処理年度の対象者LのList
     */
    List<HihokenshaDaichoTempSixColumnEntity> select処理年度の対象者2();

    /**
     * 被保険者番号指定の対象者2を取得する。
     *
     * @return 被保険者番号指定度の対象者LのList
     */
    List<HihokenshaDaichoTempSixColumnEntity> select被保険者番号指定の対象者2();

    /**
     * 対象世帯員クラスTempに更新4。
     *
     * @return UpdTaishoSeitaiyinTemp4EntityのList
     */
    List<UpdTaishoSeitaiyinTemp4Entity> 対象世帯員クラスTempに更新4();

    /**
     * 対象世帯員クラスTempに更新5。
     *
     * @return TaishoSetaiinEntityのList
     */
    List<TaishoSetaiinEntity> 対象世帯員クラスTempに更新5();

    /**
     * 対象世帯員クラスTempに更新5。
     *
     * @param para UpdTaishoSeitaiyinTemp5ProcessMybatisParameter
     * @return 件数 int
     */
    int get該当件数(UpdTaishoSeitaiyinTemp5ProcessMybatisParameter para);

    /**
     * 宛先宛名に取得する。
     *
     * @param para CreateTaishoSetaiyinProcessMybatisParameter
     * @return CreateTaishoSetaiyinEntityのList
     */
    List<CreateTaishoSetaiyinEntity> get宛先宛名(CreateTaishoSetaiyinProcessMybatisParameter para);

    /**
     * 対象世帯員する。
     *
     * @return TaishoSetaiinEntityのList
     */
    List<TaishoSetaiinEntity> insert基準収入額適用管理();

    /**
     * 処理日付管理マスタに取得する。
     *
     * @param para UpdTaishoSeitaiyinTemp5ProcessMybatisParameter
     * @return 件数 int
     */
    int select処理日付管理マスタ(UpdTaishoSeitaiyinTemp5ProcessMybatisParameter para);

    /**
     * 処理日付管理マスタ異動分に取得する。
     *
     * @param para UpdTaishoSeitaiyinTemp5ProcessMybatisParameter
     * @return 件数 int
     */
    int select処理日付管理マスタ異動分(UpdTaishoSeitaiyinTemp5ProcessMybatisParameter para);

    /**
     * 対象世帯員クラスTempに更新。
     *
     * @param para UpdTaishoSeitaiyinTemp5ProcessMybatisParameter
     */
    void update処理日付管理マスタ(UpdTaishoSeitaiyinTemp5ProcessMybatisParameter para);

    /**
     * 対象世帯員クラスTempにinsert。
     *
     * @param para UpdTaishoSeitaiyinTemp5ProcessMybatisParameter
     */
    void insert処理日付管理マスタ(UpdTaishoSeitaiyinTemp5ProcessMybatisParameter para);

    /**
     * 対象世帯員クラスTempにinsert。
     *
     * @param para UpdTaishoSeitaiyinTemp5ProcessMybatisParameter
     */
    void insert処理日付管理マスタ_異動分(UpdTaishoSeitaiyinTemp5ProcessMybatisParameter para);

    /**
     * 対象世帯員クラスTempに更新。
     *
     * @param para UpdTaishoSeitaiyinTemp5ProcessMybatisParameter
     */
    void update処理日付管理マスタ_異動分(UpdTaishoSeitaiyinTemp5ProcessMybatisParameter para);
}

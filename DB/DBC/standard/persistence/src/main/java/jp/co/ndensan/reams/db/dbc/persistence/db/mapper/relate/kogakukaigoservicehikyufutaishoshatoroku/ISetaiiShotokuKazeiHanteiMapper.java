/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.SetaiShotokuKazeiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinJigyoHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TmpSetaiHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TmpSetaiJigyoHaakuNyuryokuEntity;

/**
 * 高額介護サービス費給付対象者取込みDB操作です。
 *
 * @reamsid_L DBC-2010-090 jiangzongyue
 */
public interface ISetaiiShotokuKazeiHanteiMapper {

    /**
     * creat世帯員所得情報高額一時テーブルメソッドです。
     */
    void creat世帯員所得情報高額一時();

    /**
     * creat世帯員所得情報事業高額一時テーブルメソッドです。
     */
    void creat世帯員所得情報事業高額一時();

    /**
     * insert世帯員所得情報高額一時に一括住所地特例該当が1です。
     */
    void insert世帯員所得情報高額一時に一括住所地特例該当が1();

    /**
     * insert世帯員所得情報高額一時に一括住所地特例該当が1以外です。
     *
     * @param parameter SetaiShotokuKazeiHanteiMybatisParameter
     */
    void insert世帯員所得情報高額一時に一括住所地特例該当が1以外(SetaiShotokuKazeiHanteiMybatisParameter parameter);

    /**
     * insert世帯員所得情報事業高額一時に一括住所地特例該当が1です。
     */
    void insert世帯員所得情報事業高額一時に一括住所地特例該当が1();

    /**
     * insert世帯員所得情報事業高額一時に一括住所地特例該当が1以外です。
     *
     * @param parameter SetaiShotokuKazeiHanteiMybatisParameter
     */
    void insert世帯員所得情報事業高額一時に一括住所地特例該当が1以外(SetaiShotokuKazeiHanteiMybatisParameter parameter);

    /**
     * select世帯員所得情報高額一時に一括テーブルメソッドです。
     *
     * @return TempSetaiinHaakuNyuryokuEntity
     */
    TempSetaiinHaakuNyuryokuEntity select世帯員所得情報高額一時に一括();

    /**
     * select世帯員所得情報高額一時に一括テーブルメソッドです。
     *
     * @return TempSetaiinJigyoHaakuNyuryokuEntity
     */
    TempSetaiinJigyoHaakuNyuryokuEntity select世帯員所得情報事業高額一時に一括();

    /**
     * update世帯員所得情報高額一時合併内住所地特例者番号変換処理メソッドです。
     */
    void update世帯員所得情報高額一時合併内住所地特例者番号変換処理();

    /**
     * update世帯員所得情報事業高額一時合併内住所地特例者番号変換処理メソッドです。
     */
    void update世帯員所得情報事業高額一時合併内住所地特例者番号変換処理();

    /**
     * update高額介護サービス場合メソッドです。
     */
    void update高額介護サービス場合();

    /**
     * update事業高額介護サービス場合メソッドです。
     */
    void update事業高額介護サービス場合();

    /**
     * select取得した内容で世帯員所得情報高額一時に生保区分を更新メソッドです。
     *
     * @return TmpSetaiHaakuNyuryokuEntity
     */
    int select取得した内容で世帯員所得情報高額一時に生保区分を更新();

    /**
     * select取得した内容で世帯員所得情報高額一時に生保区分を更新メソッドです。
     *
     * @return int
     */
    int select取得した内容で世帯員所得情報高額一時に老齢福祉区分を更新();

    /**
     * select取得した内容で世帯員所得情報高額一時に生保区分を更新メソッドです。
     *
     * @return int
     */
    int select取得した内容で世帯員所得情報事業高額一時に生保区分を更新();

    /**
     * select取得した内容で世帯員所得情報高額一時に生保区分を更新メソッドです。
     *
     * @return int
     */
    int select取得した内容で世帯員所得情報事業高額一時に老齢福祉区分を更新();

    /**
     * update世帯員所得情報高額一時生保区分を付加するメソッドです。
     */
    void update世帯員所得情報高額一時生保区分を付加する();

    /**
     * update世帯員所得情報高額一時老齢福祉区分を更新するメソッドです。
     */
    void update世帯員所得情報高額一時老齢福祉区分を更新する();

    /**
     * update世帯員所得情報事業高額一時生保区分を付加するメソッドです。
     */
    void update世帯員所得情報事業高額一時生保区分を付加する();

    /**
     * update世帯員所得情報事業高額一時老齢福祉区分を更新するメソッドです。
     */
    void update世帯員所得情報事業高額一時老齢福祉区分を更新する();

    /**
     * insert世帯員所得情報高額一時に一括テーブルメソッドです。
     *
     * @param list TmpSetaiHaakuNyuryokuEntity
     */
    void insert世帯員所得情報高額一時に一括(List<TmpSetaiHaakuNyuryokuEntity> list);

    /**
     * insert世帯員所得情報高額一時に一括テーブルメソッドです。
     *
     * @param list List<TmpSetaiJigyoHaakuNyuryokuEntity>
     */
    void insert世帯員所得情報事業高額一時に一括(List<TmpSetaiJigyoHaakuNyuryokuEntity> list);

    //for test
    /**
     * creat世帯員把握入力高額一時テーブルメソッドです。
     */
    void creat世帯員把握入力高額一時();

    /**
     * creat世帯員把握入力事業高額一時テーブルメソッドです。
     */
    void creat世帯員把握入力事業高額一時();

    /**
     * insert世帯員把握入力高額一時テーブルメソッドです。
     */
    void insert世帯員把握入力高額一時();

    /**
     * insert世帯員把握入力事業高額一時テーブルメソッドです。
     */
    void insert世帯員把握入力事業高額一時();

    /**
     * insert世帯員把握入力事業高額一時テーブルメソッドです。
     */
    void insert世帯員把握入力高額一時test1();

    /**
     * insert世帯員把握入力事業高額一時テーブルメソッドです。
     */
    void insert世帯員把握入力事業高額一時test();

    /**
     * insert世帯員把握入力事業高額一時テーブルメソッドです。
     */
    void insertFortestJuminShotokuJoho();
}

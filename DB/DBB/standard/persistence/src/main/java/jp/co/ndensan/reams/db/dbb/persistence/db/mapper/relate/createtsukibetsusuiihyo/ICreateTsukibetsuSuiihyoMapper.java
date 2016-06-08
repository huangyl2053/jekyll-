/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.createtsukibetsusuiihyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GemmenJyoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GennendoDate;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.HihokenshaDaichoPsm;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.KoumokuGoukey;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.KoumokuSyoukeyi;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.NinsuKinkaku;

/**
 * 月別推移表作成のmapperクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public interface ICreateTsukibetsuSuiihyoMapper {

    /**
     * 特別徴収帳票データの取得の処理です。
     *
     * @return List<KoumokuGoukey>
     */
    List<KoumokuGoukey> get特別徴収帳票データの取得();

    /**
     * 普通徴収帳票データの取得の処理です。
     *
     * @return List<KoumokuGoukey>
     */
    List<KoumokuGoukey> get普通徴収帳票データの取得();

    /**
     * 合計帳票データの取得の処理です。
     *
     * @return List<KoumokuGoukey>
     */
    List<KoumokuGoukey> get合計帳票データの取得();

    /**
     * 減免帳票データの取得の処理です。
     *
     * @return List<GemmenJyoho>
     */
    List<GemmenJyoho> get減免帳票データの取得();

    /**
     * 被保険者台帳管理と宛名のデータ取得します。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<HihokenshaDaichoPsm>
     */
    List<HihokenshaDaichoPsm> get被保険者台帳管理と宛名のデータ(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 各月資格の取得します。
     *
     * @return List<HihokenshaDaichoPsm>
     */
    List<HihokenshaDaichoPsm> get各月資格の取得();

    /**
     * データの取得
     *
     * @return List<GennendoDate>
     */
    List<GennendoDate> getデータの取得();

    /**
     * 現年度データ取得します。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<GennendoDate>
     */
    List<GennendoDate> get現年度データの取得(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 過年度のデータの取得します。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<GennendoDate>
     */
    List<GennendoDate> get過年度のデータの取得(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 不明のデータの取得します。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<GennendoDate>
     */
    List<GennendoDate> get不明のデータの取得(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 減免部分のデータの取得します。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<GennendoDate>
     */
    List<GennendoDate> get減免部分のデータの取得(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 4月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get4月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 5月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get5月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 6月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get6月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 7月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get7月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 8月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get8月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 9月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get9月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 10月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get10月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 11月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get11月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 12月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get12月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 1月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get1月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 2月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get2月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 3月の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get3月の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 現年随時の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get現年随時の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 過年度の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get過年度の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 特別徴収歳出還付の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get特別徴収歳出還付の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 普通徴収歳出還付の人数金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get普通徴収歳出還付の人数金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 不明の人数と金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get不明の人数と金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 減免部分の人数と金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get減免部分の人数と金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 減免部分合計の人数と金額の取得処理です。
     *
     * @param parameter 別推移表作成のMyBatis用パラメータクラス
     * @return List<NinsuKinkaku>
     */
    List<NinsuKinkaku> get減免部分合計の人数と金額(CreateTsukibetsuSuiihyoMyBatisParameter parameter);

    /**
     * 減免部分過年度の人数合計と金額合計の取得処理です。
     *
     * @return 減免情報のEntityクラス
     */
    GemmenJyoho get減免部分過年度の人数合計と金額合計();

    /**
     * 該当段階の過年度の人数と金額合計の取得処理です。
     *
     * @return List<GemmenJyoho>
     */
    List<GemmenJyoho> get該当段階の過年度の人数と金額合計();

    /**
     * 項目小計一時テーブルデータの取得処理です。
     *
     * @return List<KoumokuSyoukeyi>
     */
    List<KoumokuSyoukeyi> get項目小計一時テーブルデータの取得();

    /**
     * 項目小計一時テーブル合計データの取得処理です。
     *
     * @return List<KoumokuSyoukeyi>
     */
    List<KoumokuSyoukeyi> get項目小計一時テーブル合計データの取得();

    /**
     * 項目合計一時テーブルデータの取得処理です。
     *
     * @return List<KoumokuGoukey>
     */
    List<KoumokuGoukey> get項目合計一時テーブルデータの取得();

    /**
     * 項目合計一時テーブル合計データの取得処理です。
     *
     * @return KoumokuGoukey 合計部分合計値Entityクラス
     */
    KoumokuGoukey get項目合計一時テーブル合計データの取得();
}

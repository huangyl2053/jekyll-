/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijohosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.gogitaijohosakusei.GogitaiJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaijoho.GogitaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.TempGogitaiJohoSakuseiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体情報作成のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0090-010 chengsanyuan
 */
public interface IGogitaiJohoSakuseiMapper {

    /**
     * 合議体情報Gridデータを取得します。
     *
     * @param param 合議体情報作成のパラメータ
     * @return List<GogitaiJohoSakuseiRelateEntity>
     */
    List<GogitaiJohoSakuseiRelateEntity> getGogitaiJohoSakuseiGridList(GogitaiJohoSakuseiParameter param);

    /**
     * 合議体情報Gridデータを取得します。
     *
     * @param param 合議体情報作成のパラメータ
     * @return List<GogitaiJohoRelateEntity>
     */
    List<GogitaiJohoRelateEntity> selectGogitaiJohoSakusei(GogitaiJohoSakuseiParameter param);

    /**
     * 審査員一覧のデータを取得します。
     *
     * @param param 合議体情報作成のパラメータ
     * @return List<GogitaiJohoSakuseiRelateEntity>
     */
    List<GogitaiJohoSakuseiRelateEntity> getShinsainList(GogitaiJohoSakuseiParameter param);

    /**
     * CSV出力内容を取得します。
     *
     * @param param 合議体情報作成のパラメータ
     * @return List<GogitaiJohoSakuseiRelateEntity>
     */
    List<GogitaiJohoSakuseiRelateEntity> getGogitaiJohoForCSV(GogitaiJohoSakuseiParameter param);

    /**
     * 一時テーブルの合議体情報データを取得します。
     *
     * @return List<TempGogitaiJohoSakuseiEntity>
     */
    List<TempGogitaiJohoSakuseiEntity> getTempGogitaiJohoSakuseiSearchResult();

    /**
     * 合議体情報データを取得します。
     *
     * @param param 合議体情報作成のパラメータ
     * @return List<GogitaiJohoSakuseiEntity>
     */
    List<GogitaiJohoSakuseiEntity> getGogitaiJohoByYukoKikanKaishiYMD(GogitaiJohoSakuseiParameter param);

    /**
     * 開催場所コードの存在をチェックします。
     *
     * @param shinsakaiKaisaiBashoCode 開催場所コード
     * @return int
     */
    int getKaisaiBashoJohoCount(RString shinsakaiKaisaiBashoCode);

    /**
     * 審査会委員コードの存在をチェックします。
     *
     * @param shinsakaiIinCode 審査会委員コード
     * @return int
     */
    int getShinsakaiIinJohoCount(RString shinsakaiIinCode);

    /**
     * 「合議体割当委員情報」テーブルの存在をチェックします。
     *
     * @param param 合議体情報作成のパラメータ
     * @return int
     */
    int getGogitaiWariateIinJohoCount(GogitaiJohoSakuseiParameter param);
}

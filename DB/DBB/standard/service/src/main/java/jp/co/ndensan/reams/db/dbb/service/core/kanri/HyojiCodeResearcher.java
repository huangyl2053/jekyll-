/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji1;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji2;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji3;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 表示コードのクラスです。
 */
public class HyojiCodeResearcher {

    private final DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac;

    /**
     * コンストラクタです。
     */
    public HyojiCodeResearcher() {
        this.dbT7065Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dbT7065Dac DbT7065ChohyoSeigyoKyotsuDac
     */
    HyojiCodeResearcher(DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac) {
        this.dbT7065Dac = dbT7065Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HyojiCodeResearcher}のインスタンスを返します。
     *
     * @return HyojiCodeResearcher
     */
    public static HyojiCodeResearcher createInstance() {
        return InstanceProvider.create(HyojiCodeResearcher.class);
    }

    /**
     * 表示コード名称を取得します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return 表示コード名称
     */
    public SearchResult<RString> get表示コード名称(ReportId 帳票分類ID) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));

        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = dbT7065Dac.selectByHyoujiCode(帳票分類ID);
        return get表示コード名称(dbT7065Entity);
    }

    /**
     * 表示コードを取得します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return 表示コード情報
     */
    // TODO 王暁冬 QA723 仕様書と基盤ソース不一致　2016/02/24
    public HyojiCodes get表示コード(ReportId 帳票分類ID) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));

        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = dbT7065Dac.selectByHyoujiCode(帳票分類ID);
        return create表示コード情報(dbT7065Entity);
    }

    /**
     * 表示コード名称を取得します。
     *
     * @param 帳票制御共通情報 帳票制御共通情報
     * @return 表示コード名称 SearchResult<RString>
     */
    // TODO 王暁冬 QA723 仕様書と基盤ソース不一致　2016/02/24
    public SearchResult<RString> get表示コード名称(DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報) {
        requireNonNull(帳票制御共通情報, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通情報"));

        List<RString> 表示コード名称 = new ArrayList<>();
        表示コード名称.add(ChikuHyoji1.toValue(帳票制御共通情報.getChikuHyoji1()).get名称());
        表示コード名称.add(ChikuHyoji2.toValue(帳票制御共通情報.getChikuHyoji2()).get名称());
        表示コード名称.add(ChikuHyoji3.toValue(帳票制御共通情報.getChikuHyoji3()).get名称());
        return SearchResult.of(表示コード名称, 0, false);
    }

    /**
     * 表示コード情報を作成します。
     *
     * @param 帳票制御共通情報 帳票制御共通
     * @return 表示コード情報
     */
    // TODO 王暁冬 QA723 仕様書と基盤ソース不一致　2016/02/24
    public HyojiCodes create表示コード情報(DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報) {
        requireNonNull(帳票制御共通情報, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通情報"));

        HyojiCodes hyojiCodes = new HyojiCodes();
        hyojiCodes.set表示コード１(帳票制御共通情報.getChikuHyoji1());
        hyojiCodes.set表示コード名１(ChikuHyoji1.toValue(帳票制御共通情報.getChikuHyoji1()).get名称());
        hyojiCodes.set表示コード２(帳票制御共通情報.getChikuHyoji2());
        hyojiCodes.set表示コード名２(ChikuHyoji2.toValue(帳票制御共通情報.getChikuHyoji2()).get名称());
        hyojiCodes.set表示コード３(帳票制御共通情報.getChikuHyoji3());
        hyojiCodes.set表示コード名３(ChikuHyoji3.toValue(帳票制御共通情報.getChikuHyoji3()).get名称());

        return hyojiCodes;
    }
}

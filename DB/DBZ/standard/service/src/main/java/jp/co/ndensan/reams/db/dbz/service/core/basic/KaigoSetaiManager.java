/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoSetai;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7014KaigoSetaiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護世帯を管理するクラスです。
 */
public class KaigoSetaiManager {

    private final DbT7014KaigoSetaiDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoSetaiManager() {
        dac = InstanceProvider.create(DbT7014KaigoSetaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7014KaigoSetaiDac}
     */
    KaigoSetaiManager(DbT7014KaigoSetaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護世帯を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 管理識別区分 KanriShikibetsuKubun
     * @param 世帯把握基準年月日 SetaiHaakuKijunYMD
     * @param 世帯員管理連番 SetaiInkanriRenban
     * @param 世帯員識別コード SetaiInshikibetsuCode
     * @param 本人区分 HonninKubun
     * @param 課税年度 KazeiNendo
     * @param 課税非課税区分 KazeiHikazeiKubun
     * @return KaigoSetai
     */
    @Transaction
    public KaigoSetai get介護世帯(
            HihokenshaNo 被保険者番号,
            RString 管理識別区分,
            FlexibleDate 世帯把握基準年月日,
            int 世帯員管理連番,
            ShikibetsuCode 世帯員識別コード,
            RString 本人区分,
            FlexibleYear 課税年度,
            RString 課税非課税区分) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理識別区分"));
        requireNonNull(世帯把握基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯把握基準年月日"));
        requireNonNull(世帯員管理連番, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員管理連番"));
        requireNonNull(世帯員識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員識別コード"));
        requireNonNull(本人区分, UrSystemErrorMessages.値がnull.getReplacedMessage("本人区分"));
        requireNonNull(課税年度, UrSystemErrorMessages.値がnull.getReplacedMessage("課税年度"));
        requireNonNull(課税非課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("課税非課税区分"));

        DbT7014KaigoSetaiEntity entity = dac.selectByKey(
                被保険者番号,
                管理識別区分,
                世帯把握基準年月日,
                世帯員管理連番,
                世帯員識別コード,
                本人区分,
                課税年度,
                課税非課税区分);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoSetai(entity);
    }

    /**
     * 介護世帯を全件返します。
     *
     * @return List<KaigoSetai>
     */
    @Transaction
    public List<KaigoSetai> get介護世帯一覧() {
        List<KaigoSetai> businessList = new ArrayList<>();

        for (DbT7014KaigoSetaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoSetai(entity));
        }

        return businessList;
    }

    /**
     * 介護世帯{@link KaigoSetai}を保存します。
     *
     * @param 介護世帯 {@link KaigoSetai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護世帯(KaigoSetai 介護世帯) {
        requireNonNull(介護世帯, UrSystemErrorMessages.値がnull.getReplacedMessage("介護世帯"));
        if (!介護世帯.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護世帯.toEntity());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShichosonJouhouResult;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyosakusei.RegistShoriDateKanriParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheinjunkakakutei.RegistShoriDateKanriProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokujohoichiranhyosakusei.IShotokuJohoIchiranhyoSakuseiMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタを登録する
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
public class RegistShoriDateKanriProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final int INDEX_0 = 0;
    private static final int INDEX_8 = 8;
    private static final RString INDEX_111 = new RString("111");
    private static final RString INDEX_112 = new RString("112");
    private static final RString INDEX_120 = new RString("120");
    private static final RString 処理枝番 = new RString("0001");
    private static final RString 年度内枝番 = new RString("0001");
    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db."
            + "mapper.relate.shotokujohoichiranhyosakusei.IShotokuJohoIchiranhyoSakuseiMapper");
    private static final RString 処理日付管理 = new RString(MAPPER_PATH + ".select処理日付管理マスタ_単一市町村");
    private DbT7022ShoriDateKanriEntity 処理日付管理Entity;
    private List<ShichosonJouhouResult> 市町村情報リスト;
    private List<DbT7022ShoriDateKanriEntity> 処理日付管理リスト;
    private RegistShoriDateKanriProcessParameter processparameter;
    private RegistShoriDateKanriParameter parameter;
    private IShotokuJohoIchiranhyoSakuseiMapper mapper;
    private RString 導入形態コード;

    @Override
    public void initialize() {
        parameter = creatParameter(processparameter);
        導入形態コード = parameter.get導入形態コード();
        市町村情報リスト = parameter.get市町村情報リスト();
        mapper = getMapper(IShotokuJohoIchiranhyoSakuseiMapper.class);
        LasdecCode 市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        parameter.set市町村コード(市町村コード);
        処理日付管理リスト = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(処理日付管理, parameter);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity item) {
        if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            処理日付管理Entity = item.clone();
        }
    }

    @Override
    protected void afterExecute() {
        if (INDEX_111.equals(導入形態コード)) {
            for (ShichosonJouhouResult result : 市町村情報リスト) {
                parameter.set市町村コード(result.get市町村コード());
                parameter.set市町村識別ID(result.get市町村識別ID());
                処理日付管理Entity = mapper.select処理日付管理マスタ_広域市町村(parameter);
                処理日付管理リスト.add(処理日付管理Entity);
            }
        }
        YMDHMS 開始日時 = parameter.get抽出期間開始日時();
        YMDHMS 終了日時 = parameter.get抽出期間終了日時();
        if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            for (ShichosonJouhouResult 市町村情報 : 市町村情報リスト) {
                if (処理日付管理Entity != null) {
                    update処理日付管理マスタ_単一(開始日時, 終了日時);
                } else {
                    add処理日付管理マスタ_単一(開始日時, 終了日時, 市町村情報);
                }
            }
        } else if (INDEX_111.equals(導入形態コード)) {
            for (ShichosonJouhouResult 市町村情報 : 市町村情報リスト) {
                if (!処理日付管理.isEmpty()) {
                    update処理日付管理マスタ_広域(開始日時, 終了日時, 市町村情報);
                } else {
                    add処理日付管理マスタ_広域(開始日時, 終了日時, 市町村情報);
                }
            }
        }
    }

    private void add処理日付管理マスタ_単一(YMDHMS 開始日時, YMDHMS 終了日時, ShichosonJouhouResult 市町村情報) {
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        entity.setShichosonCode(parameter.get市町村コード());
        entity.setShoriName(new RString(ShoriName.所得情報一覧表作成.toString()));
        entity.setShoriEdaban(処理枝番);
        entity.setNendo(parameter.get処理年度());
        entity.setNendoNaiRenban(年度内枝番);
        entity.setKijunYMD(new FlexibleDate(YMDHMS.now().toString().substring(INDEX_0, INDEX_8)));
        entity.setTaishoKaishiYMD(new FlexibleDate(開始日時.toString().substring(INDEX_0, INDEX_8)));
        entity.setTaishoShuryoYMD(new FlexibleDate(終了日時.toString().substring(INDEX_0, INDEX_8)));
        RString 対象開始日時 = new RString(市町村情報.get開始年月日().toString()).concat(市町村情報.get開始時刻());
        RString 対象終了日時 = new RString(市町村情報.get終了年月日().toString()).concat(市町村情報.get終了時刻());
        entity.setTaishoKaishiTimestamp(new YMDHMS(対象開始日時.toString()));
        entity.setTaishoShuryoTimestamp(new YMDHMS(対象終了日時.toString()));
        mapper.add処理日付管理マスタ(entity);
    }

    private void add処理日付管理マスタ_広域(YMDHMS 開始日時, YMDHMS 終了日時, ShichosonJouhouResult 市町村情報) {
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        entity.setShichosonCode(市町村情報.get市町村コード());
        entity.setShoriName(new RString(ShoriName.所得情報一覧表作成.toString()));
        entity.setShoriEdaban(市町村情報.get市町村識別ID());
        entity.setNendo(parameter.get処理年度());
        entity.setNendoNaiRenban(年度内枝番);
        entity.setKijunYMD(new FlexibleDate(YMDHMS.now().toString().substring(INDEX_0, INDEX_8)));
        entity.setTaishoKaishiYMD(new FlexibleDate(開始日時.toString().substring(INDEX_0, INDEX_8)));
        entity.setTaishoShuryoYMD(new FlexibleDate(終了日時.toString().substring(INDEX_0, INDEX_8)));
        RString 対象開始日時 = new RString(市町村情報.get開始年月日().toString()).concat(市町村情報.get開始時刻());
        entity.setTaishoKaishiTimestamp(new YMDHMS(対象開始日時.toString()));
        RString 対象終了日時 = new RString(市町村情報.get終了年月日().toString()).concat(市町村情報.get終了時刻());
        entity.setTaishoShuryoTimestamp(new YMDHMS(対象終了日時.toString()));
        mapper.add処理日付管理マスタ(entity);
    }

    private void update処理日付管理マスタ_広域(YMDHMS 開始日時, YMDHMS 終了日時, ShichosonJouhouResult 市町村情報) {
        for (DbT7022ShoriDateKanriEntity 処理日付entity : 処理日付管理リスト) {
            DbT7022ShoriDateKanriEntity entity = 処理日付entity.clone();
            entity.setKijunYMD(new FlexibleDate(YMDHMS.now().toString().substring(INDEX_0, INDEX_8)));
            entity.setTaishoKaishiYMD(new FlexibleDate(開始日時.toString().substring(INDEX_0, INDEX_8)));
            entity.setTaishoShuryoYMD(new FlexibleDate(終了日時.toString().substring(INDEX_0, INDEX_8)));
            RString 対象開始日時 = new RString(市町村情報.get開始年月日().toString()).concat(市町村情報.get開始時刻());
            entity.setTaishoKaishiTimestamp(new YMDHMS(対象開始日時.toString()));
            RString 対象終了日時 = new RString(市町村情報.get終了年月日().toString()).concat(市町村情報.get終了時刻());
            entity.setTaishoShuryoTimestamp(new YMDHMS(対象終了日時.toString()));
            mapper.update処理日付管理マスタ(entity);
        }
    }

    private void update処理日付管理マスタ_単一(YMDHMS 開始日時, YMDHMS 終了日時) {
        DbT7022ShoriDateKanriEntity entity = 処理日付管理Entity;
        entity.setKijunYMD(new FlexibleDate(YMDHMS.now().toString().substring(INDEX_0, INDEX_8)));
        entity.setTaishoKaishiYMD(new FlexibleDate(開始日時.toString().substring(INDEX_0, INDEX_8)));
        entity.setTaishoShuryoYMD(new FlexibleDate(終了日時.toString().substring(INDEX_0, INDEX_8)));
        RString 対象開始日時 = new RString(開始日時.toString());
        entity.setTaishoKaishiTimestamp(new YMDHMS(対象開始日時.toString()));
        RString 対象終了日時 = new RString(終了日時.toString());
        entity.setTaishoShuryoTimestamp(new YMDHMS(対象終了日時.toString()));
        mapper.update処理日付管理マスタ(entity);
    }

    private RegistShoriDateKanriParameter creatParameter(RegistShoriDateKanriProcessParameter processparameter) {
        FlexibleYear 処理年度 = processparameter.get処理年度();
        YMDHMS 開始日時 = processparameter.get抽出期間開始日時();
        YMDHMS 終了日時 = processparameter.get抽出期間終了日時();
        RegistShoriDateKanriParameter param = new RegistShoriDateKanriParameter(
                processparameter.get導入形態コード(), 処理年度, 開始日時, 終了日時, LasdecCode.EMPTY, RString.EMPTY,
                processparameter.get市町村情報リスト());
        return param;
    }

}

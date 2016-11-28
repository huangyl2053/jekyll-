/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsKaigohokenNenkinTaishosha1ProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuchoIraiInsertDataEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * （特徴依頼）年金特徴対象者情報の登録します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsKaigohokenNenkinTokuchoTaishosha1Process extends BatchProcessBase<TokuchoIraiInsertDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get対象者情報追加用データ");
    private static final RString DT各種区分_03 = new RString("03");
    private static final RString 個人コード区分_0 = new RString("0");
    private static final RString 捕捉年月日の日 = new RString("01");
    private static final RString 待機フラグ_待機なし = new RString("0");
    private static final int 個人コード_MAX_LENGTH = 16;

    private int max連番;
    private long シーケンス;
    private RString 基礎年金番号;
    private RString 年金コード;
    private InsKaigohokenNenkinTaishosha1ProcessParameter parameter;

    @BatchWriter
    BatchPermanentTableWriter 介護保険年金特徴対象者情報;

    @Override
    protected void initialize() {
        max連番 = 1;
        シーケンス = 0;
        基礎年金番号 = null;
        年金コード = null;
    }

    @Override
    protected void createWriter() {
        介護保険年金特徴対象者情報 = new BatchPermanentTableWriter(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);

    }

    @Override
    protected void beforeExecute() {
        Integer 連番 = getMapper(ITokuChoSoufuJohoSakuseiBatchMapper.class).getMAX連番();
        if (連番 != null) {
            max連番 = 連番 + 1;
        }
    }

    @Override
    protected void process(TokuchoIraiInsertDataEntity t) {
        UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entity = 介護保険年金特徴対象者情報の設定(t);
        介護保険年金特徴対象者情報.insert(entity);
    }

    private UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity 介護保険年金特徴対象者情報の設定(TokuchoIraiInsertDataEntity t) {
        UeT0511NenkinTokuchoKaifuJohoEntity 対象者情報 = t.get対象者情報();
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理Newest = t.get被保険者台帳管理Newest();
        UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entity = new UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity();
        entity.setRenban(max連番);
        entity.setKisoNenkinNo(対象者情報.getKisoNenkinNo());
        entity.setNenkinCode(対象者情報.getNenkinCode());
        if (!対象者情報.getKisoNenkinNo().equals(基礎年金番号)
                || !対象者情報.getNenkinCode().equals(年金コード)) {
            シーケンス = 1;
        } else {
            シーケンス++;
        }
        entity.setSeq(シーケンス);
        基礎年金番号 = 対象者情報.getKisoNenkinNo();
        年金コード = 対象者情報.getNenkinCode();
        entity.setShoriTimestamp(parameter.getシステム日時().getRDateTime());
        entity.setDtCityCode(対象者情報.getDtCityCode());
        Code dT特別徴収義務者コード = 対象者情報.getDtTokubetsuChoshuGimushaCode();
        if (dT特別徴収義務者コード != null) {
            entity.setDtTokubetsuChoshuGimushaCode(dT特別徴収義務者コード.value());
        }
        entity.setDtTsuchiNaiyoCode(対象者情報.getDtTsuchiNaiyoCode());
        entity.setDtBaitaiCode(対象者情報.getDtBaitaiCode());
        entity.setDtTokubetsuChoshuSeidoCode(対象者情報.getDtTokubetsuChoshuSeidoCode());
        entity.setDtSakuseiYMD(対象者情報.getDtSakuseiYMD());
        entity.setDtKisoNenkinNo(対象者情報.getDtKisoNenkinNo());
        entity.setDtNenkinCode(対象者情報.getDtNenkinCode());
        entity.setDtYobi1(対象者情報.getDtYobi1());
        entity.setDtBirthDay(対象者情報.getDtBirthDay());
        entity.setDtSeibetsu(対象者情報.getDtSeibetsu());
        entity.setDtKanaShimei(対象者情報.getDtKanaShimei());
        entity.setDtShiftCode1(対象者情報.getDtShiftCode1());
        entity.setDtKanjiShimei(対象者情報.getDtKanjiShimei());
        entity.setDtShiftCode2(対象者情報.getDtShiftCode2());
        entity.setDtYubinNo(対象者情報.getDtYubinNo());
        entity.setDtKanaJusho(対象者情報.getDtKanaJusho());
        entity.setDtShiftCode3(対象者情報.getDtShiftCode3());
        entity.setDtKanjiJusho(対象者情報.getDtKanjiJusho());
        entity.setDtShiftCode4(対象者情報.getDtShiftCode4());
        entity.setDtKakushuKubun(対象者情報.getDtKakushuKubun());
        entity.setDtShoriKekka(対象者情報.getDtShoriKekka());
        entity.setDtKokiIkanCode(対象者情報.getDtKokiIkanCode());
        entity.setDtKakushuYMD(対象者情報.getDtKakushuYMD());
        entity.setDtKakushuKingaku1(対象者情報.getDtKakushuKingaku1());
        entity.setDtKakushuKingaku2(対象者情報.getDtKakushuKingaku2());
        entity.setDtKakushuKingaku3(対象者情報.getDtKakushuKingaku3());
        entity.setDtYobi2(対象者情報.getDtYobi2());
        entity.setDtKyosaiNenkinshoshoKigoNo(対象者情報.getDtKyosaiNenkinshoshoKigoNo());
        if (!DT各種区分_03.equals(entity.getDtKakushuKubun())) {
            entity.setKaigohokenHihokenshaNo(対象者情報.getHihokenshaNo());
            entity.setKojinCodeKubun(個人コード区分_0);
            entity.setKojinCode(get個人コード(対象者情報.getShikibetsuCode()));
            entity.setKaigohokenJushochitokureiKubun(get介護保険住所地特例区分(被保険者台帳管理Newest));
            entity.setHosokuYMD(get捕捉年月日(対象者情報));
            entity.setTaikiFlag(待機フラグ_待機なし);
        }
        return entity;
    }

    private RString get個人コード(ShikibetsuCode code) {
        if (code != null) {
            return code.value().padZeroToLeft(個人コード_MAX_LENGTH);
        }
        return RString.EMPTY.padZeroToLeft(個人コード_MAX_LENGTH);
    }

    private RString get介護保険住所地特例区分(DbT1001HihokenshaDaichoEntity 被保険者台帳管理Newest) {
        if (被保険者台帳管理Newest != null) {
            return 被保険者台帳管理Newest.getJushochiTokureiFlag();
        }
        return RString.EMPTY;
    }

    private RString get捕捉年月日(UeT0511NenkinTokuchoKaifuJohoEntity 対象者情報) {
        return 対象者情報.getShoriNendo().toDateString()
                .concat(対象者情報.getHosokuTsuki())
                .concat(捕捉年月日の日);
    }
}

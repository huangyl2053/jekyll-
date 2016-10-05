/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.jyukirendotorokushalist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba140010.JyukiRendoTorokushaListBatchProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.JyukiRendoJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.TaJushochiTokureiShayouhouEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 住基連動登録者リスト帳票用データを作成Businessクラスです。
 *
 * @reamsid_L DBA-0560-020 xuyannan
 */
public class JyukiRendoJouhouBusiness {

    private static final Code 年齢到達 = new Code("02");
    private static final Code 一号被保険者到達 = new Code("31");
    private static final int 対象情報_被保険者台帳 = 1;
    private static final int 対象情報_他市町村住所地特例者台帳 = 2;
    private static final int 対象情報_適用除外者台帳 = 3;
    private static final RString データ種別_被保険者台帳 = new RString("データ種別：被保険者台帳");
    private static final RString データ種別_他市町村住所地特例者台帳 = new RString("データ種別：他市町村住所地特例者台帳");
    private static final RString データ種別_適用除外者台帳 = new RString("データ種別：適用除外者台帳");
    private static final RString 異動情報 = new RString("異動情報");
    private static final RString 取得情報 = new RString("取得情報");
    private static final RString 喪失情報 = new RString("喪失情報");
    private static final RString 適用情報 = new RString("適用情報");
    private static final RString 解除情報 = new RString("解除情報");
    private static final RString 施設コード = new RString("施設コード");
    private static final RString 入所年月日 = new RString("入所年月日");
    private static final RString 退所年月日 = new RString("退所年月日");
    private static final RString 適用異動 = new RString("適用異動");
    private static final RString 入所異動 = new RString("入所異動");
    private static final RString 退所異動 = new RString("退所異動");
    private static final RString 解除異動 = new RString("解除異動");
    private static final RString 適用削除 = new RString("適用削除");
    private static final RString 解除削除 = new RString("解除削除");
    private static final RString 資格 = new RString("資格");
    private static final Code 転入 = new Code("01");
    private static final Code 転出 = new Code("51");
    private static final Code 死亡 = new Code("52");
    private static final Code 転居 = new Code("21");

    /**
     * パラメータを作成します。
     *
     * @param processParameter 住基連動登録者リストのバッチパラメータ
     * @return JyukiRendoTorokushaListBatchProcessParameter
     */
    public JyukiRendoTorokushaListBatchProcessParameter setPsetParameter(JyukiRendoTorokushaListBatchProcessParameter processParameter) {
        List<Code> 取得事由被保険者Codes = new ArrayList<>();
        List<Code> 適用事由他特例者Codes = new ArrayList<>();
        List<Code> 適用事由除外者Codes = new ArrayList<>();
        List<Code> 喪失事由被保険者Codes = new ArrayList<>();
        List<Code> 解除事由他特例者Codes = new ArrayList<>();
        List<Code> 解除事由除外者Codes = new ArrayList<>();
        List<Code> 変更事由被保険者Codes = new ArrayList<>();
        List<Code> 住特適用Codes = new ArrayList<>();
        List<Code> 住特解除Codes = new ArrayList<>();
        List<UzT0007CodeEntity> 取得事由被保険者List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 適用事由他特例者List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格適用事由_他特例者.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 適用事由除外者List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格適用事由_除外者.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 喪失事由被保険者List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 解除事由他特例者List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格解除事由_他特例者.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 解除事由除外者List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格解除事由_除外者.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 変更事由被保険者List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格変更事由被保険者.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 住特適用LIst = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格住特適用.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 住特解除List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格住特解除.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        for (UzT0007CodeEntity uzT0007CodeEntity : 取得事由被保険者List) {
            取得事由被保険者Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 適用事由他特例者List) {
            適用事由他特例者Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 適用事由除外者List) {
            適用事由除外者Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 喪失事由被保険者List) {
            喪失事由被保険者Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 解除事由他特例者List) {
            解除事由他特例者Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 解除事由除外者List) {
            解除事由除外者Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 変更事由被保険者List) {
            変更事由被保険者Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 住特適用LIst) {
            住特適用Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 住特解除List) {
            住特解除Codes.add(uzT0007CodeEntity.getコード());
        }
        取得事由被保険者Codes.remove(年齢到達);
        変更事由被保険者Codes.remove(一号被保険者到達);
        processParameter.setShutokuJiyu_Hihokensha(取得事由被保険者Codes);
        processParameter.setTekiyoJiyu_TaTokureisha(適用事由他特例者Codes);
        processParameter.setTekiyoJiyu_Jogaisha(適用事由除外者Codes);
        processParameter.setSoshitsuJiyu_Hihokensha(喪失事由被保険者Codes);
        processParameter.setKaijoJiyu_TaTokureisha(解除事由他特例者Codes);
        processParameter.setKaijoJiyu_Jogaisha(解除事由除外者Codes);
        processParameter.setHenkoJiyu_Hihokensha(変更事由被保険者Codes);
        processParameter.setJutokuTekiyo(住特適用Codes);
        processParameter.setJutokuKaijo(住特解除Codes);
        processParameter.setIdouJiyu_tennyu(転入);
        processParameter.setIdouJiyu_tensyutu(転出);
        processParameter.setIdouJiyu_sibou(死亡);
        processParameter.setIdouJiyu_tenkyo(転居);
        return processParameter;
    }

    /**
     *
     * 被保険者台帳リストを取得します。
     *
     * @param jyukiRendoTorokushalist 住基連動情報List
     * @param entity 住基連動情報Entity
     * @return List<JyukiRendoJouhouEntity>
     */
    public List<JyukiRendoJouhouEntity> get被保険者台帳リスト(
            List<JyukiRendoJouhouEntity> jyukiRendoTorokushalist,
            JyukiRendoJouhouEntity entity) {
        if (jyukiRendoTorokushalist.isEmpty()) {
            entity.set対象情報(対象情報_被保険者台帳);
            entity.set対象情報タイトル(データ種別_被保険者台帳);
            entity.set開始タイトル(取得情報);
            entity.set終了タイトル(喪失情報);
            entity.set区分タイトル(資格);
            entity.set異動情報タイトル4(異動情報);
            jyukiRendoTorokushalist.add(entity);
        }
        return jyukiRendoTorokushalist;
    }

    /**
     * 他住所地特例者管理リストを取得します。
     *
     * @param taJushochiTokureiShayouhoulist 他住所地特例者情報List
     * @param jyukiRendoJouhouList 住基連動情報List
     * @return List<JyukiRendoJouhouEntity>
     */
    public List<JyukiRendoJouhouEntity> get他住所地特例者管理リスト(
            List<TaJushochiTokureiShayouhouEntity> taJushochiTokureiShayouhoulist,
            List<JyukiRendoJouhouEntity> jyukiRendoJouhouList) {
        Collections.sort(taJushochiTokureiShayouhoulist, new Comparator<TaJushochiTokureiShayouhouEntity>() {
            @Override
            public int compare(TaJushochiTokureiShayouhouEntity entity1, TaJushochiTokureiShayouhouEntity entity2) {
                return entity2.getLastUpdateTimestamp().compareTo(entity1.getLastUpdateTimestamp());
            }
        });
        for (TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou : taJushochiTokureiShayouhoulist) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set対象情報(対象情報_他市町村住所地特例者台帳);
            entity.set対象情報タイトル(データ種別_他市町村住所地特例者台帳);
            entity.set開始タイトル(適用情報);
            entity.set終了タイトル(解除情報);
            entity.set異動情報タイトル1(施設コード);
            entity.set開始年月日タイトル(入所年月日);
            entity.set終了年月日タイトル(退所年月日);
            entity.set異動情報タイトル4(異動情報);
            entity.set異動情報データ1(taJushochiTokureiShayouhou.getNyushoShisetsuCode());
            entity.set識別コード(taJushochiTokureiShayouhou.getShikibetsuCode());
            if (!taJushochiTokureiShayouhou.isLogicalDeletedFlag()) {
                set異動情報(entity,
                        taJushochiTokureiShayouhou,
                        DBACodeShubetsu.介護資格適用事由_他特例者.getコード().value(),
                        DBACodeShubetsu.介護資格解除事由_他特例者.getコード().value());
            } else {
                if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                        && !CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                                DBACodeShubetsu.介護資格適用事由_他特例者.getコード(),
                                new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString()),
                                new FlexibleDate(RDate.getNowDate().toDateString())).isEmpty()) {
                    set適用削除情報(entity, taJushochiTokureiShayouhou);
                } else if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                        && !CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                                DBACodeShubetsu.介護資格解除事由_他特例者.getコード(),
                                new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString()),
                                new FlexibleDate(RDate.getNowDate().toDateString())).isEmpty()) {
                    set解除削除情報(entity, taJushochiTokureiShayouhou);
                }
            }
            jyukiRendoJouhouList.add(entity);
        }
        if (taJushochiTokureiShayouhoulist.isEmpty()) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set対象情報(対象情報_他市町村住所地特例者台帳);
            entity.set対象情報タイトル(データ種別_他市町村住所地特例者台帳);
            set住基連動情報(entity);
            jyukiRendoJouhouList.add(entity);
        }
        return jyukiRendoJouhouList;
    }

    /**
     * 適用除外者台帳リストを取得します。
     *
     * @param taJushochiTokureiShayouhoulist 他住所地特例者情報List
     * @param jyukiRendoJouhouList 住基連動情報List
     * @return List<JyukiRendoJouhouEntity>
     */
    public List<JyukiRendoJouhouEntity> get適用除外者台帳リスト(
            List<TaJushochiTokureiShayouhouEntity> taJushochiTokureiShayouhoulist,
            List<JyukiRendoJouhouEntity> jyukiRendoJouhouList) {
        Collections.sort(taJushochiTokureiShayouhoulist, new Comparator<TaJushochiTokureiShayouhouEntity>() {
            @Override
            public int compare(TaJushochiTokureiShayouhouEntity entity1, TaJushochiTokureiShayouhouEntity entity2) {
                int flag = entity2.getShikibetsuCode().compareTo(entity1.getShikibetsuCode());
                if (0 == flag) {
                    flag = entity2.getLastUpdateTimestamp().compareTo(entity1.getLastUpdateTimestamp());
                }
                return flag;
            }
        });
        for (TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou : taJushochiTokureiShayouhoulist) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set対象情報(対象情報_適用除外者台帳);
            entity.set対象情報タイトル(データ種別_適用除外者台帳);
            entity.set開始タイトル(適用情報);
            entity.set終了タイトル(解除情報);
            entity.set異動情報タイトル1(施設コード);
            entity.set開始年月日タイトル(入所年月日);
            entity.set終了年月日タイトル(退所年月日);
            entity.set異動情報タイトル4(異動情報);
            entity.set異動情報データ1(taJushochiTokureiShayouhou.getNyushoShisetsuCode());
            entity.set識別コード(taJushochiTokureiShayouhou.getShikibetsuCode());
            if (!taJushochiTokureiShayouhou.isLogicalDeletedFlag()) {
                set異動情報(entity, taJushochiTokureiShayouhou, DBACodeShubetsu.介護資格適用事由_除外者.getコード().value(),
                        DBACodeShubetsu.介護資格解除事由_除外者.getコード().value());
            } else {
                if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                        && !CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                                DBACodeShubetsu.介護資格適用事由_除外者.getコード(),
                                new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString()),
                                new FlexibleDate(RDate.getNowDate().toDateString())).isEmpty()) {
                    set適用削除情報(entity, taJushochiTokureiShayouhou);
                } else if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                        && !CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                                DBACodeShubetsu.介護資格解除事由_除外者.getコード(),
                                new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString()),
                                new FlexibleDate(RDate.getNowDate().toDateString())).isEmpty()) {
                    set解除削除情報(entity, taJushochiTokureiShayouhou);
                }
            }
            jyukiRendoJouhouList.add(entity);
        }
        if (jyukiRendoJouhouList.isEmpty()) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set対象情報(対象情報_適用除外者台帳);
            entity.set対象情報タイトル(データ種別_適用除外者台帳);
            set住基連動情報(entity);
            jyukiRendoJouhouList.add(entity);
        }
        return jyukiRendoJouhouList;
    }

    /**
     * 事由名称を取得します。
     *
     * @param entity 住基連動情報Entity
     */
    public void set事由名称(JyukiRendoJouhouEntity entity) {
        if (データ種別_被保険者台帳.equals(entity.get対象情報タイトル())) {
            entity.set取得情報_前_事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), entity.get取得情報_前_事由()));
            entity.set取得情報_後_事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), entity.get取得情報_後_事由()));
            entity.set喪失情報_前_事由(getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), entity.get喪失情報_前_事由()));
            entity.set喪失情報_後_事由(getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), entity.get喪失情報_後_事由()));
        } else if (データ種別_他市町村住所地特例者台帳.equals(entity.get対象情報タイトル())) {
            entity.set取得情報_前_事由(getCodeNameByCode(DBACodeShubetsu.介護資格適用事由_他特例者.getコード(), entity.get取得情報_前_事由()));
            entity.set取得情報_後_事由(getCodeNameByCode(DBACodeShubetsu.介護資格適用事由_他特例者.getコード(), entity.get取得情報_後_事由()));
            entity.set喪失情報_前_事由(getCodeNameByCode(DBACodeShubetsu.介護資格解除事由_他特例者.getコード(), entity.get喪失情報_前_事由()));
            entity.set喪失情報_後_事由(getCodeNameByCode(DBACodeShubetsu.介護資格解除事由_他特例者.getコード(), entity.get喪失情報_後_事由()));
        } else if (データ種別_適用除外者台帳.equals(entity.get対象情報タイトル())) {
            entity.set取得情報_前_事由(getCodeNameByCode(DBACodeShubetsu.介護資格適用事由_除外者.getコード(), entity.get取得情報_前_事由()));
            entity.set取得情報_後_事由(getCodeNameByCode(DBACodeShubetsu.介護資格適用事由_除外者.getコード(), entity.get取得情報_後_事由()));
            entity.set喪失情報_前_事由(getCodeNameByCode(DBACodeShubetsu.介護資格解除事由_除外者.getコード(), entity.get喪失情報_前_事由()));
            entity.set喪失情報_後_事由(getCodeNameByCode(DBACodeShubetsu.介護資格解除事由_除外者.getコード(), entity.get喪失情報_後_事由()));
        }
    }

    private void set異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou,
            RString codeShuBetsuIti,
            RString codeShuBetsuNi) {
        if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                && !CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                        new CodeShubetsu(codeShuBetsuIti.toString()),
                        new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString()),
                        new FlexibleDate(RDate.getNowDate().toDateString())).isEmpty()) {
            set適用異動情報(entity, taJushochiTokureiShayouhou);
        } else if (taJushochiTokureiShayouhou.getIdoJiyuCode() == null
                && taJushochiTokureiShayouhou.getNyushoYMD() != null
                && taJushochiTokureiShayouhou.getTaishoYMD() == null) {
            set入所異動情報(entity, taJushochiTokureiShayouhou);
        } else if (taJushochiTokureiShayouhou.getIdoJiyuCode() == null
                && taJushochiTokureiShayouhou.getNyushoYMD() != null
                && taJushochiTokureiShayouhou.getTaishoYMD() != null) {
            set退所異動情報(entity, taJushochiTokureiShayouhou);
        } else if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                && !CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                        new CodeShubetsu(codeShuBetsuNi.toString()),
                        new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString()),
                        new FlexibleDate(RDate.getNowDate().toDateString())).isEmpty()) {
            set解除異動情報(entity, taJushochiTokureiShayouhou);
        }
    }

    private void set適用異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set取得情報_後_事由(taJushochiTokureiShayouhou.getIdoJiyuCode());
        entity.set取得情報_後_異動年月日(taJushochiTokureiShayouhou.getTekiyoYMD());
        entity.set取得情報_後_届出年月日(taJushochiTokureiShayouhou.getTekiyoTodokedeYMD());
        entity.set開始年月日データ_後(taJushochiTokureiShayouhou.getNyushoYMD());
        entity.set異動情報データ4(適用異動);
    }

    private void set入所異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set開始年月日データ_後(taJushochiTokureiShayouhou.getNyushoYMD());
        entity.set異動情報データ4(入所異動);
    }

    private void set退所異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set開始年月日データ_後(taJushochiTokureiShayouhou.getNyushoYMD());
        entity.set終了年月日データ_後(taJushochiTokureiShayouhou.getTaishoYMD());
        entity.set異動情報データ4(退所異動);
    }

    private void set解除異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set喪失情報_後_事由(taJushochiTokureiShayouhou.getIdoJiyuCode());
        entity.set喪失情報_後_異動年月日(taJushochiTokureiShayouhou.getKaijoYMD());
        entity.set喪失情報_後_届出年月日(taJushochiTokureiShayouhou.getKaijoTodokedeYMD());
        entity.set終了年月日データ_後(taJushochiTokureiShayouhou.getTaishoYMD());
        entity.set異動情報データ4(解除異動);
    }

    private void set適用削除情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set取得情報_前_事由(taJushochiTokureiShayouhou.getIdoJiyuCode());
        entity.set取得情報_前_異動年月日(taJushochiTokureiShayouhou.getTekiyoYMD());
        entity.set取得情報_前_届出年月日(taJushochiTokureiShayouhou.getTekiyoTodokedeYMD());
        entity.set開始年月日データ_前(taJushochiTokureiShayouhou.getNyushoYMD());
        entity.set異動情報データ4(適用削除);
    }

    private void set解除削除情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set喪失情報_前_事由(taJushochiTokureiShayouhou.getIdoJiyuCode());
        entity.set喪失情報_前_異動年月日(taJushochiTokureiShayouhou.getKaijoYMD());
        entity.set喪失情報_前_届出年月日(taJushochiTokureiShayouhou.getKaijoTodokedeYMD());
        entity.set終了年月日データ_前(taJushochiTokureiShayouhou.getTaishoYMD());
        entity.set異動情報データ4(解除削除);
    }

    private void set住基連動情報(JyukiRendoJouhouEntity entity) {
        entity.set開始タイトル(適用情報);
        entity.set終了タイトル(解除情報);
        entity.set異動情報タイトル1(施設コード);
        entity.set開始年月日タイトル(入所年月日);
        entity.set終了年月日タイトル(退所年月日);
        entity.set異動情報タイトル4(異動情報);
    }

    private RString getCodeNameByCode(CodeShubetsu codeShubetsu, RString code) {
        if (RString.isNullOrEmpty(code)) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(
                SubGyomuCode.DBA介護資格,
                codeShubetsu,
                new Code(code),
                new FlexibleDate(RDate.getNowDate().toDateString()));
    }
}

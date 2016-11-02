/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.nenreitotatsutorokushalist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba150010.NenreiTotatsuTorokushaListProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsushaJouhouEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 年齢到達登録者リスト帳票用データを作成Businessクラスです。
 *
 * @reamsid_L DBA-0570-020 xuyannan
 */
public class NenreiTotatsuTorokushaBusiness {

    private static final RString データ種別_被保険者台帳 = new RString("データ種別：被保険者台帳");
    private static final RString 取得情報 = new RString("取得情報");
    private static final RString 喪失情報 = new RString("喪失情報");
    private static final RString 資格 = new RString("資格");
    private static final RString 異動情報 = new RString("異動情報");
    private static final int 対象情報 = 1;
    private static final Code CODE_取得事由被保険者 = new Code("02");
    private static final Code CODE_変更事由被保険者 = new Code("31");

    /**
     * パラメータを作成します。
     *
     * @param processParameter 年齢到達登録者リストのバッチパラメータ
     * @return NenreiTotatsuTorokushaListProcessParameter
     */
    public NenreiTotatsuTorokushaListProcessParameter setParameter(NenreiTotatsuTorokushaListProcessParameter processParameter) {
        List<Code> 喪失事由被保険者Codes = new ArrayList<>();
        List<Code> 住特適用Codes = new ArrayList<>();
        List<Code> 住特解除Codes = new ArrayList<>();
        List<UzT0007CodeEntity> 喪失事由被保険者List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 住特適用LIst = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格住特適用.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 住特解除List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格住特解除.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        for (UzT0007CodeEntity uzT0007CodeEntity : 喪失事由被保険者List) {
            喪失事由被保険者Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 住特適用LIst) {
            住特適用Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 住特解除List) {
            住特解除Codes.add(uzT0007CodeEntity.getコード());
        }
        processParameter.setShutokuJiyu_Hihokensha(CODE_取得事由被保険者);
        processParameter.setSoshitsuJiyu_Hihokensha(喪失事由被保険者Codes);
        processParameter.setHenkoJiyu_Hihokensha(CODE_変更事由被保険者);
        processParameter.setJutokuTekiyo(住特適用Codes);
        processParameter.setJutokuKaijo(住特解除Codes);
        return processParameter;
    }

    /**
     * 帳票タイトルのデータを作成します。
     *
     * @param nenreiTotatsushaJouhoulist 年齢到達登録者リストEntity
     * @return NenreiTotatsuTorokushaListEntity
     */
    public List<NenreiTotatsushaJouhouEntity> setPrintTitleData(List<NenreiTotatsushaJouhouEntity> nenreiTotatsushaJouhoulist) {
        if (nenreiTotatsushaJouhoulist.isEmpty()) {
            NenreiTotatsushaJouhouEntity nenreiTotatsushaJouhouEntity = new NenreiTotatsushaJouhouEntity();
            nenreiTotatsushaJouhouEntity.set対象情報タイトル(データ種別_被保険者台帳);
            nenreiTotatsushaJouhouEntity.set対象情報(対象情報);
            nenreiTotatsushaJouhouEntity.set開始タイトル(取得情報);
            nenreiTotatsushaJouhouEntity.set終了タイトル(喪失情報);
            nenreiTotatsushaJouhouEntity.set区分タイトル(資格);
            nenreiTotatsushaJouhouEntity.set異動情報タイトル4(異動情報);
            nenreiTotatsushaJouhoulist.add(nenreiTotatsushaJouhouEntity);
        }
        return nenreiTotatsushaJouhoulist;
    }

    /**
     * 事由コードを事由名称に変更します。
     *
     * @param entity 年齢到達者情報Entity
     * @return NenreiTotatsushaJouhouEntity
     */
    public NenreiTotatsushaJouhouEntity setCodeToName(NenreiTotatsushaJouhouEntity entity) {
        entity.set取得情報_前_事由(
                getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), entity.get取得情報_前_事由()));
        entity.set取得情報_後_事由(
                getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), entity.get取得情報_後_事由()));
        entity.set喪失情報_前_事由(
                getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), entity.get喪失情報_前_事由()));
        entity.set喪失情報_後_事由(
                getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), entity.get喪失情報_後_事由()));
        return entity;
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

    /**
     * 帳票分類ID「DBA200008_NenreitotatsuKakuninList」年齢到達者登録リスト出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("yubinNo"), new RString("\"ShikibetsuTaisho_yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("choikiCode"), new RString("\"ShikibetsuTaisho_choikiCode\"")),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString("banchiCode"),
                new RString("\"ShikibetsuTaisho_banchiCode1\",\"ShikibetsuTaisho_banchiCode2\","
                        + "\"ShikibetsuTaisho_banchiCode3\",\"ShikibetsuTaisho_banchiCode4\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("gyoseikuCode"), new RString("\"ShikibetsuTaisho_gyoseikuCode\"")),
        /**
         * 地区１
         */
        地区１(new RString("0005"), new RString("chiku1"), new RString("\"ShikibetsuTaisho_chikuCode1\"")),
        /**
         * 地区２
         */
        地区２(new RString("0006"), new RString("chiku2"), new RString("\"ShikibetsuTaisho_chikuCode2\"")),
        /**
         * 地区３
         */
        地区３(new RString("0007"), new RString("chiku3"), new RString("\"ShikibetsuTaisho_chikuCode3\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("setaiCode"), new RString("\"ShikibetsuTaisho_setaiCode\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("shikibetsuCode"), new RString("\"shikibetsuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("shimei50onKana"), new RString("\"ShikibetsuTaisho_kanaMeisho\"")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("seinengappiYMD"), new RString("\"ShikibetsuTaisho_seinengappiYMD\"")),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString("gender"), new RString("\"ShikibetsuTaisho_seibetsuCode\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("\"shichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("hihokenshaNo"), new RString("\"hihokenshaNo\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaDataCsvProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaBasicDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputBatchRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 認定調査データ出力（モバイル）CSVEntity設定のビジネスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
public class NinteiChosaDataOutputResult {

    private static final RString ステータス設定値 = new RString("未");

    /**
     * EucCsvEntityの設定メッソドです。
     *
     * @param entityParam NinteiChosaBasicDataRelateEntity
     * @return NinteiChosaDataOutputEucCsvEntity
     */
    public NinteiChosaDataOutputEucCsvEntity setEucCsvEntity(NinteiChosaBasicDataRelateEntity entityParam) {
        NinteiChosaDataOutputEucCsvEntity eucCsvEntity = new NinteiChosaDataOutputEucCsvEntity();
        set今回分Entity(entityParam, eucCsvEntity);
        set前回分Entity(entityParam, eucCsvEntity);
        return eucCsvEntity;
    }

    private void set今回分Entity(NinteiChosaBasicDataRelateEntity entityParam, NinteiChosaDataOutputEucCsvEntity eucCsvEntity) {
        NinteiChosaDataOutputBatchRelateEntity entity = entityParam.get今回分Entity();
        eucCsvEntity.set申請書管理番号(entity.get申請書管理番号());
        eucCsvEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        eucCsvEntity.set厚労省認定ソフトのバージョン(KoroshoIfShikibetsuCode.toValue(entity.get厚労省IF識別コード()).get名称());
        eucCsvEntity.set証記載保険者番号(entity.get証記載保険者番号());
        eucCsvEntity.set被保険者番号(entity.get被保険者番号());
        eucCsvEntity.set認定申請年月日(entity.get認定申請年月日());
        eucCsvEntity.set認定申請区分申請時コード(entity.get認定申請区分_申請時_コード());
        eucCsvEntity.set認定申請区分申請時(NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分_申請時_コード()).get名称());
        eucCsvEntity.set被保険者氏名(entity.get被保険者氏名());
        eucCsvEntity.set被保険者氏名カナ(entity.get被保険者氏名カナ());
        eucCsvEntity.set生年月日(entity.get生年月日());
        eucCsvEntity.set年齢(entity.get年齢());
        eucCsvEntity.set性別(entity.get性別());
        eucCsvEntity.set郵便番号(setYobuinNoFormat(entity.get郵便番号()));
        eucCsvEntity.set住所(entity.get住所());
        eucCsvEntity.set電話番号(entity.get電話番号());
        eucCsvEntity.set保険者名(entity.get市町村名称());
        eucCsvEntity.set認定調査依頼完了年月日(entity.get認定調査依頼完了年月日());
        eucCsvEntity.set認定調査依頼履歴番号(entity.get認定調査依頼履歴番号());
        eucCsvEntity.set認定調査委託先コード(entity.get認定調査委託先コード());
        eucCsvEntity.set調査委託先(entity.get事業者名称());
        eucCsvEntity.set認定調査員コード(entity.get認定調査員コード());
        eucCsvEntity.set調査員氏名(entity.get調査員氏名());
        eucCsvEntity.set概況特記テキスト_イメージ区分コード(entity.getイメージ区分());
        if (RString.isNullOrEmpty(entity.getイメージ区分())) {
            eucCsvEntity.set概況特記テキスト_イメージ区分(RString.EMPTY);
        } else {
            eucCsvEntity.set概況特記テキスト_イメージ区分(TokkijikoTextImageKubun.toValue(entity.getイメージ区分()).get名称());
        }
        eucCsvEntity.set認定調査依頼区分コード(entity.get認定調査依頼区分コード());
        if (RString.isNullOrEmpty(entity.get認定調査依頼区分コード())) {
            eucCsvEntity.set認定調査依頼区分(RString.EMPTY);
        } else {
            eucCsvEntity.set認定調査依頼区分(NinteiChousaIraiKubunCode.toValue(entity.get認定調査依頼区分コード()).get名称());
        }
        eucCsvEntity.set認定調査回数(entity.get認定調査回数());
        eucCsvEntity.set認定調査実施年月日(entity.get認定調査実施年月日());
        eucCsvEntity.set認定調査受領年月日(entity.get認定調査受領年月日());

        eucCsvEntity.set認定調査区分コード(entity.get認定調査区分コード());
        if (RString.isNullOrEmpty(entity.get認定調査区分コード())) {
            eucCsvEntity.set認定調査区分(RString.EMPTY);
        } else {
            eucCsvEntity.set認定調査区分(NinteiChousaIraiKubunCode.toValue(entity.get認定調査区分コード()).get名称());
        }
        eucCsvEntity.set認定調査実施場所コード(entity.get認定調査実施場所コード());
        if (RString.isNullOrEmpty(entity.get認定調査実施場所コード())) {
            eucCsvEntity.set認定調査実施場所(RString.EMPTY);
        } else {
            eucCsvEntity.set認定調査実施場所(ChosaJisshiBashoCode.toValue(entity.get認定調査実施場所コード()).get名称());
        }
        eucCsvEntity.set認定調査実施場所名称(entity.get認定調査実施場所名称());
        eucCsvEntity.set家族等連絡先郵便番号(entity.get申請届出者郵便番号());
        eucCsvEntity.set家族等電話番号(entity.get申請届出者電話番号());
        eucCsvEntity.set家族等住所(entity.get申請届出者住所());
        eucCsvEntity.set家族等氏名(entity.get申請届出者氏名());
        eucCsvEntity.set調査対象者との関係(entity.get申請届出者続柄());
        eucCsvEntity.set認定調査_サービス区分コード(entity.getサービス区分コード());
        if (RString.isNullOrEmpty(entity.getサービス区分コード())) {
            eucCsvEntity.set認定調査_サービス区分(RString.EMPTY);
        } else {
            eucCsvEntity.set認定調査_サービス区分(ServiceKubunCode.toValue(entity.getサービス区分コード()).get名称());
        }
        eucCsvEntity.set利用施設名(entity.get利用施設名());
        eucCsvEntity.set利用施設住所(entity.get利用施設住所());
        eucCsvEntity.set利用施設電話番号(entity.get利用施設電話番号());
        eucCsvEntity.set利用施設郵便番号(setYobuinNoFormat(entity.get利用施設郵便番号()));
        eucCsvEntity.set特記(entity.get特記());
        eucCsvEntity.set認定調査特記事項受付年月日(entity.get認定調査特記事項受付年月日());
        eucCsvEntity.set認定調査特記事項受領年月日(entity.get認定調査特記事項受領年月日());
        eucCsvEntity.set住宅改修_改修箇所(entity.get住宅改修());
        eucCsvEntity.set市町村特別給付サービス種類名(entity.get市町村特別給付サービス種類名());
        eucCsvEntity.set介護保険給付以外の在宅サービス種類名(entity.get在宅サービス種類名());
        setサービス状況_今回(eucCsvEntity, entity);
        setサービス状況フラグ_今回(eucCsvEntity, entity);
        setサービス状況記入_今回(eucCsvEntity, entity);
        set施設利用_今回(eucCsvEntity, entity);
        eucCsvEntity.set認定調査_認知症高齢者の日常生活自立度コード(entity.get認知症日常生活自立度コード());
        if (RString.isNullOrEmpty(entity.get認知症日常生活自立度コード())) {
            eucCsvEntity.set認定調査_認知症高齢者の日常生活自立度(RString.EMPTY);
        } else {
            eucCsvEntity.set認定調査_認知症高齢者の日常生活自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get認知症日常生活自立度コード()).get名称());
        }
        eucCsvEntity.set認定調査_障害高齢者の日常生活自立度コード(entity.get障害日常生活自立度コード());
        if (RString.isNullOrEmpty(entity.get障害日常生活自立度コード())) {
            eucCsvEntity.set認定調査_障害高齢者の日常生活自立度(RString.EMPTY);
        } else {
            eucCsvEntity.set認定調査_障害高齢者の日常生活自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get障害日常生活自立度コード()).get名称());
        }
        set調査項目_今回(eucCsvEntity, entity);
        eucCsvEntity.setステータス(ステータス設定値);
        eucCsvEntity.set被保険者区分(entity.get被保険者区分コード());
    }

    private void set前回分Entity(NinteiChosaBasicDataRelateEntity entityParam, NinteiChosaDataOutputEucCsvEntity eucCsvEntity) {
        NinteiChosaDataOutputBatchRelateEntity entityZenkai = entityParam.get前回分Entity();
        eucCsvEntity.set前回_証記載保険者番号(entityZenkai.get証記載保険者番号());
        eucCsvEntity.set前回_被保険者番号(entityZenkai.get被保険者番号());
        eucCsvEntity.set前回_認定申請年月日(entityZenkai.get認定申請年月日());
        eucCsvEntity.set前回_認定調査_サービス区分コード(entityZenkai.getサービス区分コード());
        if (RString.isNullOrEmpty(entityZenkai.getサービス区分コード())) {
            eucCsvEntity.set前回_認定調査_サービス区分(RString.EMPTY);
        } else {
            eucCsvEntity.set前回_認定調査_サービス区分(ServiceKubunCode.toValue(entityZenkai.getサービス区分コード()).get名称());
        }
        setサービス状況_前回(eucCsvEntity, entityZenkai);
        setサービス状況フラグ_前回(eucCsvEntity, entityZenkai);
        setサービス状況記入_前回(eucCsvEntity, entityZenkai);
        set施設利用_前回(eucCsvEntity, entityZenkai);

        eucCsvEntity.set前回_認定調査_認知症高齢者の日常生活自立度コード(entityZenkai.get認知症日常生活自立度コード());
        if (RString.isNullOrEmpty(entityZenkai.get認知症日常生活自立度コード())) {
            eucCsvEntity.set前回_認定調査_認知症高齢者の日常生活自立度(RString.EMPTY);
        } else {
            eucCsvEntity.set前回_認定調査_認知症高齢者の日常生活自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(entityZenkai.get認知症日常生活自立度コード()).get名称());
        }
        eucCsvEntity.set前回_認定調査_障害高齢者の日常生活自立度コード(entityZenkai.get障害日常生活自立度コード());
        if (RString.isNullOrEmpty(entityZenkai.get障害日常生活自立度コード())) {
            eucCsvEntity.set前回_認定調査_障害高齢者の日常生活自立度(RString.EMPTY);
        } else {
            eucCsvEntity.set前回_認定調査_障害高齢者の日常生活自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(entityZenkai.get障害日常生活自立度コード()).get名称());
        }
        set調査項目_前回(eucCsvEntity, entityZenkai);
    }

    private void setサービス状況_今回(NinteiChosaDataOutputEucCsvEntity eucCsvEntity, NinteiChosaDataOutputBatchRelateEntity entity) {
        eucCsvEntity.setサービスの状況連番01(entity.get状況連番1());
        eucCsvEntity.setサービスの状況01(entity.get状況1());
        eucCsvEntity.setサービスの状況連番02(entity.get状況連番2());
        eucCsvEntity.setサービスの状況02(entity.get状況2());
        eucCsvEntity.setサービスの状況連番03(entity.get状況連番3());
        eucCsvEntity.setサービスの状況03(entity.get状況3());
        eucCsvEntity.setサービスの状況連番04(entity.get状況連番4());
        eucCsvEntity.setサービスの状況04(entity.get状況4());
        eucCsvEntity.setサービスの状況連番05(entity.get状況連番5());
        eucCsvEntity.setサービスの状況05(entity.get状況5());
        eucCsvEntity.setサービスの状況連番06(entity.get状況連番6());
        eucCsvEntity.setサービスの状況06(entity.get状況6());
        eucCsvEntity.setサービスの状況連番07(entity.get状況連番7());
        eucCsvEntity.setサービスの状況07(entity.get状況7());
        eucCsvEntity.setサービスの状況連番08(entity.get状況連番8());
        eucCsvEntity.setサービスの状況08(entity.get状況8());
        eucCsvEntity.setサービスの状況連番09(entity.get状況連番9());
        eucCsvEntity.setサービスの状況09(entity.get状況9());
        eucCsvEntity.setサービスの状況連番10(entity.get状況連番10());
        eucCsvEntity.setサービスの状況10(entity.get状況10());
        eucCsvEntity.setサービスの状況連番11(entity.get状況連番11());
        eucCsvEntity.setサービスの状況11(entity.get状況11());
        eucCsvEntity.setサービスの状況連番12(entity.get状況連番12());
        eucCsvEntity.setサービスの状況12(entity.get状況12());
        eucCsvEntity.setサービスの状況連番13(entity.get状況連番13());
        eucCsvEntity.setサービスの状況13(entity.get状況13());
        eucCsvEntity.setサービスの状況連番14(entity.get状況連番14());
        eucCsvEntity.setサービスの状況14(entity.get状況14());
        eucCsvEntity.setサービスの状況連番15(entity.get状況連番15());
        eucCsvEntity.setサービスの状況15(entity.get状況15());
        eucCsvEntity.setサービスの状況連番16(entity.get状況連番16());
        eucCsvEntity.setサービスの状況16(entity.get状況16());
        eucCsvEntity.setサービスの状況連番17(entity.get状況連番17());
        eucCsvEntity.setサービスの状況17(entity.get状況17());
        eucCsvEntity.setサービスの状況連番18(entity.get状況連番18());
        eucCsvEntity.setサービスの状況18(entity.get状況18());
        eucCsvEntity.setサービスの状況連番19(entity.get状況連番19());
        eucCsvEntity.setサービスの状況19(entity.get状況19());
        eucCsvEntity.setサービスの状況連番20(entity.get状況連番20());
        eucCsvEntity.setサービスの状況20(entity.get状況20());
    }

    private void setサービス状況フラグ_今回(NinteiChosaDataOutputEucCsvEntity eucCsvEntity, NinteiChosaDataOutputBatchRelateEntity entity) {
        eucCsvEntity.setサービスの状況フラグ連番(entity.get状況フラグ連番1());
        eucCsvEntity.setサービスの状況フラグ(entity.get状況フラグ1());
    }

    private void setサービス状況記入_今回(NinteiChosaDataOutputEucCsvEntity eucCsvEntity, NinteiChosaDataOutputBatchRelateEntity entity) {
        eucCsvEntity.set記入項目連番01(entity.get記入項目連番1());
        eucCsvEntity.setサービスの状況記入01(entity.get状況記入1());
        eucCsvEntity.set記入項目連番02(entity.get記入項目連番2());
        eucCsvEntity.setサービスの状況記入02(entity.get状況記入2());
    }

    private void set施設利用_今回(NinteiChosaDataOutputEucCsvEntity eucCsvEntity, NinteiChosaDataOutputBatchRelateEntity entity) {
        eucCsvEntity.set施設利用連番01(entity.get施設利用連番1());
        eucCsvEntity.set施設利用フラグ01(entity.get施設利用フラグ1());
        eucCsvEntity.set施設利用連番02(entity.get施設利用連番2());
        eucCsvEntity.set施設利用フラグ02(entity.get施設利用フラグ2());
        eucCsvEntity.set施設利用連番03(entity.get施設利用連番3());
        eucCsvEntity.set施設利用フラグ03(entity.get施設利用フラグ3());
        eucCsvEntity.set施設利用連番04(entity.get施設利用連番4());
        eucCsvEntity.set施設利用フラグ04(entity.get施設利用フラグ4());
        eucCsvEntity.set施設利用連番05(entity.get施設利用連番5());
        eucCsvEntity.set施設利用フラグ05(entity.get施設利用フラグ5());
        eucCsvEntity.set施設利用連番06(entity.get施設利用連番6());
        eucCsvEntity.set施設利用フラグ06(entity.get施設利用フラグ6());
        eucCsvEntity.set施設利用連番07(entity.get施設利用連番7());
        eucCsvEntity.set施設利用フラグ07(entity.get施設利用フラグ7());
        eucCsvEntity.set施設利用連番08(entity.get施設利用連番8());
        eucCsvEntity.set施設利用フラグ08(entity.get施設利用フラグ8());
        eucCsvEntity.set施設利用連番09(entity.get施設利用連番9());
        eucCsvEntity.set施設利用フラグ09(entity.get施設利用フラグ9());
    }

    @SuppressWarnings(value = {"methodlength"}) //項目数が74件あるため無視する。
    private void set調査項目_今回(NinteiChosaDataOutputEucCsvEntity eucCsvEntity, NinteiChosaDataOutputBatchRelateEntity entity) {
        eucCsvEntity.set調査項目連番01(entity.get調査項目連番1());
        eucCsvEntity.set調査項目文言01(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番1()));
        eucCsvEntity.set内容01(entity.get調査項目1());
        eucCsvEntity.set調査項目連番02(entity.get調査項目連番2());
        eucCsvEntity.set調査項目文言02(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番2()));
        eucCsvEntity.set内容02(entity.get調査項目2());
        eucCsvEntity.set調査項目連番03(entity.get調査項目連番3());
        eucCsvEntity.set調査項目文言03(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番3()));
        eucCsvEntity.set内容03(entity.get調査項目3());
        eucCsvEntity.set調査項目連番04(entity.get調査項目連番4());
        eucCsvEntity.set調査項目文言04(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番4()));
        eucCsvEntity.set内容04(entity.get調査項目4());
        eucCsvEntity.set調査項目連番05(entity.get調査項目連番5());
        eucCsvEntity.set調査項目文言05(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番5()));
        eucCsvEntity.set内容05(entity.get調査項目5());
        eucCsvEntity.set調査項目連番06(entity.get調査項目連番6());
        eucCsvEntity.set調査項目文言06(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番6()));
        eucCsvEntity.set内容06(entity.get調査項目6());
        eucCsvEntity.set調査項目連番07(entity.get調査項目連番7());
        eucCsvEntity.set調査項目文言07(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番7()));
        eucCsvEntity.set内容07(entity.get調査項目7());
        eucCsvEntity.set調査項目連番08(entity.get調査項目連番8());
        eucCsvEntity.set調査項目文言08(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番8()));
        eucCsvEntity.set内容08(entity.get調査項目8());
        eucCsvEntity.set調査項目連番09(entity.get調査項目連番9());
        eucCsvEntity.set調査項目文言09(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番9()));
        eucCsvEntity.set内容09(entity.get調査項目9());
        eucCsvEntity.set調査項目連番10(entity.get調査項目連番10());
        eucCsvEntity.set調査項目文言10(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番10()));
        eucCsvEntity.set内容10(entity.get調査項目10());
        eucCsvEntity.set調査項目連番11(entity.get調査項目連番11());
        eucCsvEntity.set調査項目文言11(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番11()));
        eucCsvEntity.set内容11(entity.get調査項目11());
        eucCsvEntity.set調査項目連番12(entity.get調査項目連番12());
        eucCsvEntity.set調査項目文言12(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番12()));
        eucCsvEntity.set内容12(entity.get調査項目12());
        eucCsvEntity.set調査項目連番13(entity.get調査項目連番13());
        eucCsvEntity.set調査項目文言13(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番13()));
        eucCsvEntity.set内容13(entity.get調査項目13());
        eucCsvEntity.set調査項目連番14(entity.get調査項目連番14());
        eucCsvEntity.set調査項目文言14(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番14()));
        eucCsvEntity.set内容14(entity.get調査項目14());
        eucCsvEntity.set調査項目連番15(entity.get調査項目連番15());
        eucCsvEntity.set調査項目文言15(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番15()));
        eucCsvEntity.set内容15(entity.get調査項目15());
        eucCsvEntity.set調査項目連番16(entity.get調査項目連番16());
        eucCsvEntity.set調査項目文言16(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番16()));
        eucCsvEntity.set内容16(entity.get調査項目16());
        eucCsvEntity.set調査項目連番17(entity.get調査項目連番17());
        eucCsvEntity.set調査項目文言17(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番17()));
        eucCsvEntity.set内容17(entity.get調査項目17());
        eucCsvEntity.set調査項目連番18(entity.get調査項目連番18());
        eucCsvEntity.set調査項目文言18(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番18()));
        eucCsvEntity.set内容18(entity.get調査項目18());
        eucCsvEntity.set調査項目連番19(entity.get調査項目連番19());
        eucCsvEntity.set調査項目文言19(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番19()));
        eucCsvEntity.set内容19(entity.get調査項目19());
        eucCsvEntity.set調査項目連番20(entity.get調査項目連番20());
        eucCsvEntity.set調査項目文言20(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番20()));
        eucCsvEntity.set内容20(entity.get調査項目20());
        eucCsvEntity.set調査項目連番21(entity.get調査項目連番21());
        eucCsvEntity.set調査項目文言21(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番21()));
        eucCsvEntity.set内容21(entity.get調査項目21());
        eucCsvEntity.set調査項目連番22(entity.get調査項目連番22());
        eucCsvEntity.set調査項目文言22(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番22()));
        eucCsvEntity.set内容22(entity.get調査項目22());
        eucCsvEntity.set調査項目連番23(entity.get調査項目連番23());
        eucCsvEntity.set調査項目文言23(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番23()));
        eucCsvEntity.set内容23(entity.get調査項目23());
        eucCsvEntity.set調査項目連番24(entity.get調査項目連番24());
        eucCsvEntity.set調査項目文言24(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番24()));
        eucCsvEntity.set内容24(entity.get調査項目24());
        eucCsvEntity.set調査項目連番25(entity.get調査項目連番25());
        eucCsvEntity.set調査項目文言25(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番25()));
        eucCsvEntity.set内容25(entity.get調査項目25());
        eucCsvEntity.set調査項目連番26(entity.get調査項目連番26());
        eucCsvEntity.set調査項目文言26(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番26()));
        eucCsvEntity.set内容26(entity.get調査項目26());
        eucCsvEntity.set調査項目連番27(entity.get調査項目連番27());
        eucCsvEntity.set調査項目文言27(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番27()));
        eucCsvEntity.set内容27(entity.get調査項目27());
        eucCsvEntity.set調査項目連番28(entity.get調査項目連番28());
        eucCsvEntity.set調査項目文言28(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番28()));
        eucCsvEntity.set内容28(entity.get調査項目28());
        eucCsvEntity.set調査項目連番29(entity.get調査項目連番29());
        eucCsvEntity.set調査項目文言29(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番29()));
        eucCsvEntity.set内容29(entity.get調査項目29());
        eucCsvEntity.set調査項目連番30(entity.get調査項目連番30());
        eucCsvEntity.set調査項目文言30(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番30()));
        eucCsvEntity.set内容30(entity.get調査項目30());
        eucCsvEntity.set調査項目連番31(entity.get調査項目連番31());
        eucCsvEntity.set調査項目文言31(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番31()));
        eucCsvEntity.set内容31(entity.get調査項目31());
        eucCsvEntity.set調査項目連番32(entity.get調査項目連番32());
        eucCsvEntity.set調査項目文言32(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番32()));
        eucCsvEntity.set内容32(entity.get調査項目32());
        eucCsvEntity.set調査項目連番33(entity.get調査項目連番33());
        eucCsvEntity.set調査項目文言33(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番33()));
        eucCsvEntity.set内容33(entity.get調査項目33());
        eucCsvEntity.set調査項目連番34(entity.get調査項目連番34());
        eucCsvEntity.set調査項目文言34(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番34()));
        eucCsvEntity.set内容34(entity.get調査項目34());
        eucCsvEntity.set調査項目連番35(entity.get調査項目連番35());
        eucCsvEntity.set調査項目文言35(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番35()));
        eucCsvEntity.set内容35(entity.get調査項目35());
        eucCsvEntity.set調査項目連番36(entity.get調査項目連番36());
        eucCsvEntity.set調査項目文言36(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番36()));
        eucCsvEntity.set内容36(entity.get調査項目36());
        eucCsvEntity.set調査項目連番37(entity.get調査項目連番37());
        eucCsvEntity.set調査項目文言37(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番37()));
        eucCsvEntity.set内容37(entity.get調査項目37());
        eucCsvEntity.set調査項目連番38(entity.get調査項目連番38());
        eucCsvEntity.set調査項目文言38(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番38()));
        eucCsvEntity.set内容38(entity.get調査項目38());
        eucCsvEntity.set調査項目連番39(entity.get調査項目連番39());
        eucCsvEntity.set調査項目文言39(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番39()));
        eucCsvEntity.set内容39(entity.get調査項目39());
        eucCsvEntity.set調査項目連番40(entity.get調査項目連番40());
        eucCsvEntity.set調査項目文言40(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番40()));
        eucCsvEntity.set内容40(entity.get調査項目40());
        eucCsvEntity.set調査項目連番41(entity.get調査項目連番41());
        eucCsvEntity.set調査項目文言41(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番41()));
        eucCsvEntity.set内容41(entity.get調査項目41());
        eucCsvEntity.set調査項目連番42(entity.get調査項目連番42());
        eucCsvEntity.set調査項目文言42(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番42()));
        eucCsvEntity.set内容42(entity.get調査項目42());
        eucCsvEntity.set調査項目連番43(entity.get調査項目連番43());
        eucCsvEntity.set調査項目文言43(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番43()));
        eucCsvEntity.set内容43(entity.get調査項目43());
        eucCsvEntity.set調査項目連番44(entity.get調査項目連番44());
        eucCsvEntity.set調査項目文言44(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番44()));
        eucCsvEntity.set内容44(entity.get調査項目44());
        eucCsvEntity.set調査項目連番45(entity.get調査項目連番45());
        eucCsvEntity.set調査項目文言45(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番45()));
        eucCsvEntity.set内容45(entity.get調査項目45());
        eucCsvEntity.set調査項目連番46(entity.get調査項目連番46());
        eucCsvEntity.set調査項目文言46(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番46()));
        eucCsvEntity.set内容46(entity.get調査項目46());
        eucCsvEntity.set調査項目連番47(entity.get調査項目連番47());
        eucCsvEntity.set調査項目文言47(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番47()));
        eucCsvEntity.set内容47(entity.get調査項目47());
        eucCsvEntity.set調査項目連番48(entity.get調査項目連番48());
        eucCsvEntity.set調査項目文言48(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番48()));
        eucCsvEntity.set内容48(entity.get調査項目48());
        eucCsvEntity.set調査項目連番49(entity.get調査項目連番49());
        eucCsvEntity.set調査項目文言49(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番49()));
        eucCsvEntity.set内容49(entity.get調査項目49());
        eucCsvEntity.set調査項目連番50(entity.get調査項目連番50());
        eucCsvEntity.set調査項目文言50(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番50()));
        eucCsvEntity.set内容50(entity.get調査項目50());
        eucCsvEntity.set調査項目連番51(entity.get調査項目連番51());
        eucCsvEntity.set調査項目文言51(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番51()));
        eucCsvEntity.set内容51(entity.get調査項目51());
        eucCsvEntity.set調査項目連番52(entity.get調査項目連番52());
        eucCsvEntity.set調査項目文言52(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番52()));
        eucCsvEntity.set内容52(entity.get調査項目52());
        eucCsvEntity.set調査項目連番53(entity.get調査項目連番53());
        eucCsvEntity.set調査項目文言53(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番53()));
        eucCsvEntity.set内容53(entity.get調査項目53());
        eucCsvEntity.set調査項目連番54(entity.get調査項目連番54());
        eucCsvEntity.set調査項目文言54(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番54()));
        eucCsvEntity.set内容54(entity.get調査項目54());
        eucCsvEntity.set調査項目連番55(entity.get調査項目連番55());
        eucCsvEntity.set調査項目文言55(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番55()));
        eucCsvEntity.set内容55(entity.get調査項目55());
        eucCsvEntity.set調査項目連番56(entity.get調査項目連番56());
        eucCsvEntity.set調査項目文言56(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番56()));
        eucCsvEntity.set内容56(entity.get調査項目56());
        eucCsvEntity.set調査項目連番57(entity.get調査項目連番57());
        eucCsvEntity.set調査項目文言57(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番57()));
        eucCsvEntity.set内容57(entity.get調査項目57());
        eucCsvEntity.set調査項目連番58(entity.get調査項目連番58());
        eucCsvEntity.set調査項目文言58(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番58()));
        eucCsvEntity.set内容58(entity.get調査項目58());
        eucCsvEntity.set調査項目連番59(entity.get調査項目連番59());
        eucCsvEntity.set調査項目文言59(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番59()));
        eucCsvEntity.set内容59(entity.get調査項目59());
        eucCsvEntity.set調査項目連番60(entity.get調査項目連番60());
        eucCsvEntity.set調査項目文言60(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番60()));
        eucCsvEntity.set内容60(entity.get調査項目60());
        eucCsvEntity.set調査項目連番61(entity.get調査項目連番61());
        eucCsvEntity.set調査項目文言61(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番61()));
        eucCsvEntity.set内容61(entity.get調査項目61());
        eucCsvEntity.set調査項目連番62(entity.get調査項目連番62());
        eucCsvEntity.set調査項目文言62(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番62()));
        eucCsvEntity.set内容62(entity.get調査項目62());
        eucCsvEntity.set調査項目連番63(entity.get調査項目連番63());
        eucCsvEntity.set調査項目文言63(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番63()));
        eucCsvEntity.set内容63(entity.get調査項目63());
        eucCsvEntity.set調査項目連番64(entity.get調査項目連番64());
        eucCsvEntity.set調査項目文言64(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番64()));
        eucCsvEntity.set内容64(entity.get調査項目64());
        eucCsvEntity.set調査項目連番65(entity.get調査項目連番65());
        eucCsvEntity.set調査項目文言65(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番65()));
        eucCsvEntity.set内容65(entity.get調査項目65());
        eucCsvEntity.set調査項目連番66(entity.get調査項目連番66());
        eucCsvEntity.set調査項目文言66(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番66()));
        eucCsvEntity.set内容66(entity.get調査項目66());
        eucCsvEntity.set調査項目連番67(entity.get調査項目連番67());
        eucCsvEntity.set調査項目文言67(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番67()));
        eucCsvEntity.set内容67(entity.get調査項目67());
        eucCsvEntity.set調査項目連番68(entity.get調査項目連番68());
        eucCsvEntity.set調査項目文言68(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番68()));
        eucCsvEntity.set内容68(entity.get調査項目68());
        eucCsvEntity.set調査項目連番69(entity.get調査項目連番69());
        eucCsvEntity.set調査項目文言69(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番69()));
        eucCsvEntity.set内容69(entity.get調査項目69());
        eucCsvEntity.set調査項目連番70(entity.get調査項目連番70());
        eucCsvEntity.set調査項目文言70(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番70()));
        eucCsvEntity.set内容70(entity.get調査項目70());
        eucCsvEntity.set調査項目連番71(entity.get調査項目連番71());
        eucCsvEntity.set調査項目文言71(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番71()));
        eucCsvEntity.set内容71(entity.get調査項目71());
        eucCsvEntity.set調査項目連番72(entity.get調査項目連番72());
        eucCsvEntity.set調査項目文言72(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番72()));
        eucCsvEntity.set内容72(entity.get調査項目72());
        eucCsvEntity.set調査項目連番73(entity.get調査項目連番73());
        eucCsvEntity.set調査項目文言73(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番73()));
        eucCsvEntity.set内容73(entity.get調査項目73());
        eucCsvEntity.set調査項目連番74(entity.get調査項目連番74());
        eucCsvEntity.set調査項目文言74(set調査項目文言(entity.get厚労省IF識別コード(), entity.get調査項目連番74()));
        eucCsvEntity.set内容74(entity.get調査項目74());
    }

    private void setサービス状況_前回(NinteiChosaDataOutputEucCsvEntity eucCsvEntity, NinteiChosaDataOutputBatchRelateEntity entityZenkai) {
        eucCsvEntity.set前回_サービスの状況連番01(entityZenkai.get状況連番1());
        eucCsvEntity.set前回_サービスの状況01(entityZenkai.get状況1());
        eucCsvEntity.set前回_サービスの状況連番02(entityZenkai.get状況連番2());
        eucCsvEntity.set前回_サービスの状況02(entityZenkai.get状況2());
        eucCsvEntity.set前回_サービスの状況連番03(entityZenkai.get状況連番3());
        eucCsvEntity.set前回_サービスの状況03(entityZenkai.get状況3());
        eucCsvEntity.set前回_サービスの状況連番04(entityZenkai.get状況連番4());
        eucCsvEntity.set前回_サービスの状況04(entityZenkai.get状況4());
        eucCsvEntity.set前回_サービスの状況連番05(entityZenkai.get状況連番5());
        eucCsvEntity.set前回_サービスの状況05(entityZenkai.get状況5());
        eucCsvEntity.set前回_サービスの状況連番06(entityZenkai.get状況連番6());
        eucCsvEntity.set前回_サービスの状況06(entityZenkai.get状況6());
        eucCsvEntity.set前回_サービスの状況連番07(entityZenkai.get状況連番7());
        eucCsvEntity.set前回_サービスの状況07(entityZenkai.get状況7());
        eucCsvEntity.set前回_サービスの状況連番08(entityZenkai.get状況連番8());
        eucCsvEntity.set前回_サービスの状況08(entityZenkai.get状況8());
        eucCsvEntity.set前回_サービスの状況連番09(entityZenkai.get状況連番9());
        eucCsvEntity.set前回_サービスの状況09(entityZenkai.get状況9());
        eucCsvEntity.set前回_サービスの状況連番10(entityZenkai.get状況連番10());
        eucCsvEntity.set前回_サービスの状況10(entityZenkai.get状況10());
        eucCsvEntity.set前回_サービスの状況連番11(entityZenkai.get状況連番11());
        eucCsvEntity.set前回_サービスの状況11(entityZenkai.get状況11());
        eucCsvEntity.set前回_サービスの状況連番12(entityZenkai.get状況連番12());
        eucCsvEntity.set前回_サービスの状況12(entityZenkai.get状況12());
        eucCsvEntity.set前回_サービスの状況連番13(entityZenkai.get状況連番13());
        eucCsvEntity.set前回_サービスの状況13(entityZenkai.get状況13());
        eucCsvEntity.set前回_サービスの状況連番14(entityZenkai.get状況連番14());
        eucCsvEntity.set前回_サービスの状況14(entityZenkai.get状況14());
        eucCsvEntity.set前回_サービスの状況連番15(entityZenkai.get状況連番15());
        eucCsvEntity.set前回_サービスの状況15(entityZenkai.get状況15());
        eucCsvEntity.set前回_サービスの状況連番16(entityZenkai.get状況連番16());
        eucCsvEntity.set前回_サービスの状況16(entityZenkai.get状況16());
        eucCsvEntity.set前回_サービスの状況連番17(entityZenkai.get状況連番17());
        eucCsvEntity.set前回_サービスの状況17(entityZenkai.get状況17());
        eucCsvEntity.set前回_サービスの状況連番18(entityZenkai.get状況連番18());
        eucCsvEntity.set前回_サービスの状況18(entityZenkai.get状況18());
        eucCsvEntity.set前回_サービスの状況連番19(entityZenkai.get状況連番19());
        eucCsvEntity.set前回_サービスの状況19(entityZenkai.get状況19());
        eucCsvEntity.set前回_サービスの状況連番20(entityZenkai.get状況連番20());
        eucCsvEntity.set前回_サービスの状況20(entityZenkai.get状況20());
    }

    private void setサービス状況フラグ_前回(NinteiChosaDataOutputEucCsvEntity eucCsvEntity, NinteiChosaDataOutputBatchRelateEntity entityZenkai) {
        eucCsvEntity.set前回_サービスの状況フラグ連番(entityZenkai.get状況フラグ連番1());
        eucCsvEntity.set前回_サービスの状況フラグ(entityZenkai.get状況フラグ1());
    }

    private void setサービス状況記入_前回(NinteiChosaDataOutputEucCsvEntity eucCsvEntity, NinteiChosaDataOutputBatchRelateEntity entityZenkai) {
        eucCsvEntity.set前回_記入項目連番01(entityZenkai.get記入項目連番1());
        eucCsvEntity.set前回_サービスの状況記入01(entityZenkai.get状況記入1());
        eucCsvEntity.set前回_記入項目連番02(entityZenkai.get記入項目連番2());
        eucCsvEntity.set前回_サービスの状況記入02(entityZenkai.get状況記入2());
    }

    private void set施設利用_前回(NinteiChosaDataOutputEucCsvEntity eucCsvEntity, NinteiChosaDataOutputBatchRelateEntity entityZenkai) {
        eucCsvEntity.set前回_施設利用連番01(entityZenkai.get施設利用連番1());
        eucCsvEntity.set前回_施設利用フラグ01(entityZenkai.get施設利用フラグ1());
        eucCsvEntity.set前回_施設利用連番02(entityZenkai.get施設利用連番2());
        eucCsvEntity.set前回_施設利用フラグ02(entityZenkai.get施設利用フラグ2());
        eucCsvEntity.set前回_施設利用連番03(entityZenkai.get施設利用連番3());
        eucCsvEntity.set前回_施設利用フラグ03(entityZenkai.get施設利用フラグ3());
        eucCsvEntity.set前回_施設利用連番04(entityZenkai.get施設利用連番4());
        eucCsvEntity.set前回_施設利用フラグ04(entityZenkai.get施設利用フラグ4());
        eucCsvEntity.set前回_施設利用連番05(entityZenkai.get施設利用連番5());
        eucCsvEntity.set前回_施設利用フラグ05(entityZenkai.get施設利用フラグ5());
        eucCsvEntity.set前回_施設利用連番06(entityZenkai.get施設利用連番6());
        eucCsvEntity.set前回_施設利用フラグ06(entityZenkai.get施設利用フラグ6());
        eucCsvEntity.set前回_施設利用連番07(entityZenkai.get施設利用連番7());
        eucCsvEntity.set前回_施設利用フラグ07(entityZenkai.get施設利用フラグ7());
        eucCsvEntity.set前回_施設利用連番08(entityZenkai.get施設利用連番8());
        eucCsvEntity.set前回_施設利用フラグ08(entityZenkai.get施設利用フラグ8());
        eucCsvEntity.set前回_施設利用連番09(entityZenkai.get施設利用連番9());
        eucCsvEntity.set前回_施設利用フラグ09(entityZenkai.get施設利用フラグ9());
    }

    @SuppressWarnings(value = {"methodlength"}) //項目数が74件あるため無視する。
    private void set調査項目_前回(NinteiChosaDataOutputEucCsvEntity eucCsvEntity, NinteiChosaDataOutputBatchRelateEntity entityZenkai) {
        eucCsvEntity.set前回_調査項目連番01(entityZenkai.get調査項目連番1());
        eucCsvEntity.set前回_調査項目文言01(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番1()));
        eucCsvEntity.set前回_内容01(entityZenkai.get調査項目1());
        eucCsvEntity.set前回_調査項目連番02(entityZenkai.get調査項目連番2());
        eucCsvEntity.set前回_調査項目文言02(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番2()));
        eucCsvEntity.set前回_内容02(entityZenkai.get調査項目2());
        eucCsvEntity.set前回_調査項目連番03(entityZenkai.get調査項目連番3());
        eucCsvEntity.set前回_調査項目文言03(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番3()));
        eucCsvEntity.set前回_内容03(entityZenkai.get調査項目3());
        eucCsvEntity.set前回_調査項目連番04(entityZenkai.get調査項目連番4());
        eucCsvEntity.set前回_調査項目文言04(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番4()));
        eucCsvEntity.set前回_内容04(entityZenkai.get調査項目4());
        eucCsvEntity.set前回_調査項目連番05(entityZenkai.get調査項目連番5());
        eucCsvEntity.set前回_調査項目文言05(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番5()));
        eucCsvEntity.set前回_内容05(entityZenkai.get調査項目5());
        eucCsvEntity.set前回_調査項目連番06(entityZenkai.get調査項目連番6());
        eucCsvEntity.set前回_調査項目文言06(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番6()));
        eucCsvEntity.set前回_内容06(entityZenkai.get調査項目6());
        eucCsvEntity.set前回_調査項目連番07(entityZenkai.get調査項目連番7());
        eucCsvEntity.set前回_調査項目文言07(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番7()));
        eucCsvEntity.set前回_内容07(entityZenkai.get調査項目7());
        eucCsvEntity.set前回_調査項目連番08(entityZenkai.get調査項目連番8());
        eucCsvEntity.set前回_調査項目文言08(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番8()));
        eucCsvEntity.set前回_内容08(entityZenkai.get調査項目8());
        eucCsvEntity.set前回_調査項目連番09(entityZenkai.get調査項目連番9());
        eucCsvEntity.set前回_調査項目文言09(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番9()));
        eucCsvEntity.set前回_内容09(entityZenkai.get調査項目9());
        eucCsvEntity.set前回_調査項目連番10(entityZenkai.get調査項目連番10());
        eucCsvEntity.set前回_調査項目文言10(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番10()));
        eucCsvEntity.set前回_内容10(entityZenkai.get調査項目10());
        eucCsvEntity.set前回_調査項目連番11(entityZenkai.get調査項目連番11());
        eucCsvEntity.set前回_調査項目文言11(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番11()));
        eucCsvEntity.set前回_内容11(entityZenkai.get調査項目11());
        eucCsvEntity.set前回_調査項目連番12(entityZenkai.get調査項目連番12());
        eucCsvEntity.set前回_調査項目文言12(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番12()));
        eucCsvEntity.set前回_内容12(entityZenkai.get調査項目12());
        eucCsvEntity.set前回_調査項目連番13(entityZenkai.get調査項目連番13());
        eucCsvEntity.set前回_調査項目文言13(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番13()));
        eucCsvEntity.set前回_内容13(entityZenkai.get調査項目13());
        eucCsvEntity.set前回_調査項目連番14(entityZenkai.get調査項目連番14());
        eucCsvEntity.set前回_調査項目文言14(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番14()));
        eucCsvEntity.set前回_内容14(entityZenkai.get調査項目14());
        eucCsvEntity.set前回_調査項目連番15(entityZenkai.get調査項目連番15());
        eucCsvEntity.set前回_調査項目文言15(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番15()));
        eucCsvEntity.set前回_内容15(entityZenkai.get調査項目15());
        eucCsvEntity.set前回_調査項目連番16(entityZenkai.get調査項目連番16());
        eucCsvEntity.set前回_調査項目文言16(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番16()));
        eucCsvEntity.set前回_内容16(entityZenkai.get調査項目16());
        eucCsvEntity.set前回_調査項目連番17(entityZenkai.get調査項目連番17());
        eucCsvEntity.set前回_調査項目文言17(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番17()));
        eucCsvEntity.set前回_内容17(entityZenkai.get調査項目17());
        eucCsvEntity.set前回_調査項目連番18(entityZenkai.get調査項目連番18());
        eucCsvEntity.set前回_調査項目文言18(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番18()));
        eucCsvEntity.set前回_内容18(entityZenkai.get調査項目18());
        eucCsvEntity.set前回_調査項目連番19(entityZenkai.get調査項目連番19());
        eucCsvEntity.set前回_調査項目文言19(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番19()));
        eucCsvEntity.set前回_内容19(entityZenkai.get調査項目19());
        eucCsvEntity.set前回_調査項目連番20(entityZenkai.get調査項目連番20());
        eucCsvEntity.set前回_調査項目文言20(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番20()));
        eucCsvEntity.set前回_内容20(entityZenkai.get調査項目20());
        eucCsvEntity.set前回_調査項目連番21(entityZenkai.get調査項目連番21());
        eucCsvEntity.set前回_調査項目文言21(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番21()));
        eucCsvEntity.set前回_内容21(entityZenkai.get調査項目21());
        eucCsvEntity.set前回_調査項目連番22(entityZenkai.get調査項目連番22());
        eucCsvEntity.set前回_調査項目文言22(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番22()));
        eucCsvEntity.set前回_内容22(entityZenkai.get調査項目22());
        eucCsvEntity.set前回_調査項目連番23(entityZenkai.get調査項目連番23());
        eucCsvEntity.set前回_調査項目文言23(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番23()));
        eucCsvEntity.set前回_内容23(entityZenkai.get調査項目23());
        eucCsvEntity.set前回_調査項目連番24(entityZenkai.get調査項目連番24());
        eucCsvEntity.set前回_調査項目文言24(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番24()));
        eucCsvEntity.set前回_内容24(entityZenkai.get調査項目24());
        eucCsvEntity.set前回_調査項目連番25(entityZenkai.get調査項目連番25());
        eucCsvEntity.set前回_調査項目文言25(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番25()));
        eucCsvEntity.set前回_内容25(entityZenkai.get調査項目25());
        eucCsvEntity.set前回_調査項目連番26(entityZenkai.get調査項目連番26());
        eucCsvEntity.set前回_調査項目文言26(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番26()));
        eucCsvEntity.set前回_内容26(entityZenkai.get調査項目26());
        eucCsvEntity.set前回_調査項目連番27(entityZenkai.get調査項目連番27());
        eucCsvEntity.set前回_調査項目文言27(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番27()));
        eucCsvEntity.set前回_内容27(entityZenkai.get調査項目27());
        eucCsvEntity.set前回_調査項目連番28(entityZenkai.get調査項目連番28());
        eucCsvEntity.set前回_調査項目文言28(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番28()));
        eucCsvEntity.set前回_内容28(entityZenkai.get調査項目28());
        eucCsvEntity.set前回_調査項目連番29(entityZenkai.get調査項目連番29());
        eucCsvEntity.set前回_調査項目文言29(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番29()));
        eucCsvEntity.set前回_内容29(entityZenkai.get調査項目29());
        eucCsvEntity.set前回_調査項目連番30(entityZenkai.get調査項目連番30());
        eucCsvEntity.set前回_調査項目文言30(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番30()));
        eucCsvEntity.set前回_内容30(entityZenkai.get調査項目30());
        eucCsvEntity.set前回_調査項目連番31(entityZenkai.get調査項目連番31());
        eucCsvEntity.set前回_調査項目文言31(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番31()));
        eucCsvEntity.set前回_内容31(entityZenkai.get調査項目31());
        eucCsvEntity.set前回_調査項目連番32(entityZenkai.get調査項目連番32());
        eucCsvEntity.set前回_調査項目文言32(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番32()));
        eucCsvEntity.set前回_内容32(entityZenkai.get調査項目32());
        eucCsvEntity.set前回_調査項目連番33(entityZenkai.get調査項目連番33());
        eucCsvEntity.set前回_調査項目文言33(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番33()));
        eucCsvEntity.set前回_内容33(entityZenkai.get調査項目33());
        eucCsvEntity.set前回_調査項目連番34(entityZenkai.get調査項目連番34());
        eucCsvEntity.set前回_調査項目文言34(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番34()));
        eucCsvEntity.set前回_内容34(entityZenkai.get調査項目34());
        eucCsvEntity.set前回_調査項目連番35(entityZenkai.get調査項目連番35());
        eucCsvEntity.set前回_調査項目文言35(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番35()));
        eucCsvEntity.set前回_内容35(entityZenkai.get調査項目35());
        eucCsvEntity.set前回_調査項目連番36(entityZenkai.get調査項目連番36());
        eucCsvEntity.set前回_調査項目文言36(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番36()));
        eucCsvEntity.set前回_内容36(entityZenkai.get調査項目36());
        eucCsvEntity.set前回_調査項目連番37(entityZenkai.get調査項目連番37());
        eucCsvEntity.set前回_調査項目文言37(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番37()));
        eucCsvEntity.set前回_内容37(entityZenkai.get調査項目37());
        eucCsvEntity.set前回_調査項目連番38(entityZenkai.get調査項目連番38());
        eucCsvEntity.set前回_調査項目文言38(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番38()));
        eucCsvEntity.set前回_内容38(entityZenkai.get調査項目38());
        eucCsvEntity.set前回_調査項目連番39(entityZenkai.get調査項目連番39());
        eucCsvEntity.set前回_調査項目文言39(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番39()));
        eucCsvEntity.set前回_内容39(entityZenkai.get調査項目39());
        eucCsvEntity.set前回_調査項目連番40(entityZenkai.get調査項目連番40());
        eucCsvEntity.set前回_調査項目文言40(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番40()));
        eucCsvEntity.set前回_内容40(entityZenkai.get調査項目40());
        eucCsvEntity.set前回_調査項目連番41(entityZenkai.get調査項目連番41());
        eucCsvEntity.set前回_調査項目文言41(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番41()));
        eucCsvEntity.set前回_内容41(entityZenkai.get調査項目41());
        eucCsvEntity.set前回_調査項目連番42(entityZenkai.get調査項目連番42());
        eucCsvEntity.set前回_調査項目文言42(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番42()));
        eucCsvEntity.set前回_内容42(entityZenkai.get調査項目42());
        eucCsvEntity.set前回_調査項目連番43(entityZenkai.get調査項目連番43());
        eucCsvEntity.set前回_調査項目文言43(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番43()));
        eucCsvEntity.set前回_内容43(entityZenkai.get調査項目43());
        eucCsvEntity.set前回_調査項目連番44(entityZenkai.get調査項目連番44());
        eucCsvEntity.set前回_調査項目文言44(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番44()));
        eucCsvEntity.set前回_内容44(entityZenkai.get調査項目44());
        eucCsvEntity.set前回_調査項目連番45(entityZenkai.get調査項目連番45());
        eucCsvEntity.set前回_調査項目文言45(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番45()));
        eucCsvEntity.set前回_内容45(entityZenkai.get調査項目45());
        eucCsvEntity.set前回_調査項目連番46(entityZenkai.get調査項目連番46());
        eucCsvEntity.set前回_調査項目文言46(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番46()));
        eucCsvEntity.set前回_内容46(entityZenkai.get調査項目46());
        eucCsvEntity.set前回_調査項目連番47(entityZenkai.get調査項目連番47());
        eucCsvEntity.set前回_調査項目文言47(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番47()));
        eucCsvEntity.set前回_内容47(entityZenkai.get調査項目47());
        eucCsvEntity.set前回_調査項目連番48(entityZenkai.get調査項目連番48());
        eucCsvEntity.set前回_調査項目文言48(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番48()));
        eucCsvEntity.set前回_内容48(entityZenkai.get調査項目48());
        eucCsvEntity.set前回_調査項目連番49(entityZenkai.get調査項目連番49());
        eucCsvEntity.set前回_調査項目文言49(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番49()));
        eucCsvEntity.set前回_内容49(entityZenkai.get調査項目49());
        eucCsvEntity.set前回_調査項目連番50(entityZenkai.get調査項目連番50());
        eucCsvEntity.set前回_調査項目文言50(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番50()));
        eucCsvEntity.set前回_内容50(entityZenkai.get調査項目50());
        eucCsvEntity.set前回_調査項目連番51(entityZenkai.get調査項目連番51());
        eucCsvEntity.set前回_調査項目文言51(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番51()));
        eucCsvEntity.set前回_内容51(entityZenkai.get調査項目51());
        eucCsvEntity.set前回_調査項目連番52(entityZenkai.get調査項目連番52());
        eucCsvEntity.set前回_調査項目文言52(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番52()));
        eucCsvEntity.set前回_内容52(entityZenkai.get調査項目52());
        eucCsvEntity.set前回_調査項目連番53(entityZenkai.get調査項目連番53());
        eucCsvEntity.set前回_調査項目文言53(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番53()));
        eucCsvEntity.set前回_内容53(entityZenkai.get調査項目53());
        eucCsvEntity.set前回_調査項目連番54(entityZenkai.get調査項目連番54());
        eucCsvEntity.set前回_調査項目文言54(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番54()));
        eucCsvEntity.set前回_内容54(entityZenkai.get調査項目54());
        eucCsvEntity.set前回_調査項目連番55(entityZenkai.get調査項目連番55());
        eucCsvEntity.set前回_調査項目文言55(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番55()));
        eucCsvEntity.set前回_内容55(entityZenkai.get調査項目55());
        eucCsvEntity.set前回_調査項目連番56(entityZenkai.get調査項目連番56());
        eucCsvEntity.set前回_調査項目文言56(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番56()));
        eucCsvEntity.set前回_内容56(entityZenkai.get調査項目56());
        eucCsvEntity.set前回_調査項目連番57(entityZenkai.get調査項目連番57());
        eucCsvEntity.set前回_調査項目文言57(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番57()));
        eucCsvEntity.set前回_内容57(entityZenkai.get調査項目57());
        eucCsvEntity.set前回_調査項目連番58(entityZenkai.get調査項目連番58());
        eucCsvEntity.set前回_調査項目文言58(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番58()));
        eucCsvEntity.set前回_内容58(entityZenkai.get調査項目58());
        eucCsvEntity.set前回_調査項目連番59(entityZenkai.get調査項目連番59());
        eucCsvEntity.set前回_調査項目文言59(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番59()));
        eucCsvEntity.set前回_内容59(entityZenkai.get調査項目59());
        eucCsvEntity.set前回_調査項目連番60(entityZenkai.get調査項目連番60());
        eucCsvEntity.set前回_調査項目文言60(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番60()));
        eucCsvEntity.set前回_内容60(entityZenkai.get調査項目60());
        eucCsvEntity.set前回_調査項目連番61(entityZenkai.get調査項目連番61());
        eucCsvEntity.set前回_調査項目文言61(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番61()));
        eucCsvEntity.set前回_内容61(entityZenkai.get調査項目61());
        eucCsvEntity.set前回_調査項目連番62(entityZenkai.get調査項目連番62());
        eucCsvEntity.set前回_調査項目文言62(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番62()));
        eucCsvEntity.set前回_内容62(entityZenkai.get調査項目62());
        eucCsvEntity.set前回_調査項目連番63(entityZenkai.get調査項目連番63());
        eucCsvEntity.set前回_調査項目文言63(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番63()));
        eucCsvEntity.set前回_内容63(entityZenkai.get調査項目63());
        eucCsvEntity.set前回_調査項目連番64(entityZenkai.get調査項目連番64());
        eucCsvEntity.set前回_調査項目文言64(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番64()));
        eucCsvEntity.set前回_内容64(entityZenkai.get調査項目64());
        eucCsvEntity.set前回_調査項目連番65(entityZenkai.get調査項目連番65());
        eucCsvEntity.set前回_調査項目文言65(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番65()));
        eucCsvEntity.set前回_内容65(entityZenkai.get調査項目65());
        eucCsvEntity.set前回_調査項目連番66(entityZenkai.get調査項目連番66());
        eucCsvEntity.set前回_調査項目文言66(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番66()));
        eucCsvEntity.set前回_内容66(entityZenkai.get調査項目66());
        eucCsvEntity.set前回_調査項目連番67(entityZenkai.get調査項目連番67());
        eucCsvEntity.set前回_調査項目文言67(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番67()));
        eucCsvEntity.set前回_内容67(entityZenkai.get調査項目67());
        eucCsvEntity.set前回_調査項目連番68(entityZenkai.get調査項目連番68());
        eucCsvEntity.set前回_調査項目文言68(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番68()));
        eucCsvEntity.set前回_内容68(entityZenkai.get調査項目68());
        eucCsvEntity.set前回_調査項目連番69(entityZenkai.get調査項目連番69());
        eucCsvEntity.set前回_調査項目文言69(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番69()));
        eucCsvEntity.set前回_内容69(entityZenkai.get調査項目69());
        eucCsvEntity.set前回_調査項目連番70(entityZenkai.get調査項目連番70());
        eucCsvEntity.set前回_調査項目文言70(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番70()));
        eucCsvEntity.set前回_内容70(entityZenkai.get調査項目70());
        eucCsvEntity.set前回_調査項目連番71(entityZenkai.get調査項目連番71());
        eucCsvEntity.set前回_調査項目文言71(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番71()));
        eucCsvEntity.set前回_内容71(entityZenkai.get調査項目71());
        eucCsvEntity.set前回_調査項目連番72(entityZenkai.get調査項目連番72());
        eucCsvEntity.set前回_調査項目文言72(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番72()));
        eucCsvEntity.set前回_内容72(entityZenkai.get調査項目72());
        eucCsvEntity.set前回_調査項目連番73(entityZenkai.get調査項目連番73());
        eucCsvEntity.set前回_調査項目文言73(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番73()));
        eucCsvEntity.set前回_内容73(entityZenkai.get調査項目73());
        eucCsvEntity.set前回_調査項目連番74(entityZenkai.get調査項目連番74());
        eucCsvEntity.set前回_調査項目文言74(set調査項目文言(entityZenkai.get厚労省IF識別コード(), entityZenkai.get調査項目連番74()));
        eucCsvEntity.set前回_内容74(entityZenkai.get調査項目74());
    }

    private RString set調査項目文言(RString 厚労省IF識別コード, RString 連番) {
        RString 調査項目文言 = RString.EMPTY;
        if (!RString.isNullOrEmpty(連番)) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
                調査項目文言 = NinteichosaKomokuMapping99A.toValue(連番).get名称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
                調査項目文言 = NinteichosaKomokuMapping02A.toValue(連番).get名称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
                調査項目文言 = NinteichosaKomokuMapping06A.toValue(連番).get名称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)) {
                調査項目文言 = NinteichosaKomokuMapping09A.toValue(連番).get名称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
                調査項目文言 = NinteichosaKomokuMapping09B.toValue(連番).get名称();
            }
        }
        return 調査項目文言;
    }

    private RString setYobuinNoFormat(RString yobuinNo) {
        RString formatYobuinNo = RString.EMPTY;
        if (!RString.isNullOrEmpty(yobuinNo)) {
            formatYobuinNo = new YubinNo(yobuinNo).getEditedYubinNo();
        }
        return formatYobuinNo;
    }

    /**
     * 出力件数を取得するメッソドです。
     *
     * @param 出力件数 出力件数
     * @return RString
     */
    public RString get出力件数(Decimal 出力件数) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @param processParamter processParamter
     * @return List<RString> 出力条件List
     */
    public List<RString> get出力条件(NinteiChosaDataCsvProcessParamter processParamter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(new RString("【認定調査委託先コード】"));
        jokenBuilder.append(processParamter.getNinteichosaItakusakiCode());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("【認定調査員コード】"));
        jokenBuilder.append(processParamter.getNinteiChosainCode());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("【市町村コード】"));
        jokenBuilder.append(processParamter.getShichosonCode());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("【申請書管理番号リスト】"));
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("("));
        List<RString> shinseishoKanriNoList = processParamter.getShinseishoKanriNoList();
        for (RString shinseishoKanriNo : shinseishoKanriNoList) {
            jokenBuilder.append(shinseishoKanriNo);
            jokenBuilder.append(new RString(","));
        }
        jokenBuilder.append(new RString(")"));
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void getアクセスログ(RString 申請書管理番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(申請書管理番号));
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    /**
     * アクセスログを出力するためのPersonalDataを取得するメソッドです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return PersonalData
     */
    public PersonalData getPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

}

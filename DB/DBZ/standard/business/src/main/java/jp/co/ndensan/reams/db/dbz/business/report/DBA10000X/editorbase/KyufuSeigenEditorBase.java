/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.IryoKikanAndJigyoshaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 被保険者証の、給付制限情報を編集するためのEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class KyufuSeigenEditorBase {

    private final HihokenshashoModel hihokenshashoModel;
    private final HihokenshashoPrintConfig printConfig;

    private static final int KYUFU_SEIGEN_NAME_LENGTH;
    private static final int KYUFU_SEIGEN_LONG_NAME_LENGTH;

    private static final int KYOTAKU_JIGYOSHA_NAME_STANDARD;
    private static final RString DAUB_WORD;

    static {
        KYUFU_SEIGEN_NAME_LENGTH = 8;
        KYUFU_SEIGEN_LONG_NAME_LENGTH = 12;
        KYOTAKU_JIGYOSHA_NAME_STANDARD = 40;
        DAUB_WORD = new RString("*");
    }

    /**
     * コンストラクタです。
     *
     * @param hihokenshashoModel 被保険者証Model
     * @param printConfig 被保険者証表示方法コンフィグ
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public KyufuSeigenEditorBase(HihokenshashoModel hihokenshashoModel, HihokenshashoPrintConfig printConfig) throws NullPointerException {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));
        requireNonNull(printConfig, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証表示方法コンフィグ", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
        this.printConfig = printConfig;
    }

    /**
     * 被保険者証帳票ソースに、給付制限の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set給付制限(IHihokenshashoCommonEditData source) {

        List<RString> kyufuSeigenNames = hihokenshashoModel.getShikakuHakko().get給付制限内容();
        List<RDate> kyufuSeigenStartDates = hihokenshashoModel.getShikakuHakko().get給付制限開始日();
        List<RDate> kyufuSeigenEndDates = hihokenshashoModel.getShikakuHakko().get給付制限終了日();

        for (int i = 0; i < 3 && i < kyufuSeigenNames.size(); i++) {
            switch (i) {
                case 0:
                    setKyufuSeigen(createKyufuSeigenSetter1(source),
                            kyufuSeigenNames.get(i), new Range(kyufuSeigenStartDates.get(i), kyufuSeigenEndDates.get(i)));
                    break;
                case 1:
                    setKyufuSeigen(createKyufuSeigenSetter2(source),
                            kyufuSeigenNames.get(i), new Range(kyufuSeigenStartDates.get(i), kyufuSeigenEndDates.get(i)));
                    break;
                default:
                    setKyufuSeigen(createKyufuSeigenSetter3(source),
                            kyufuSeigenNames.get(i), new Range(kyufuSeigenStartDates.get(i), kyufuSeigenEndDates.get(i)));
                    break;
            }
        }
    }

    private void setKyufuSeigen(IKyufuSeigenSetter setter, RString kyufuSeigenName, Range<RDate> kyufuRange) {
        int halfIndex;
        if (kyufuSeigenName.length() <= KYUFU_SEIGEN_NAME_LENGTH) {
            halfIndex = KYUFU_SEIGEN_NAME_LENGTH / 2;
            setter.setSeigen1(kyufuSeigenName.substring(0, halfIndex));
            setter.setSeigen2(kyufuSeigenName.substring(halfIndex, KYUFU_SEIGEN_NAME_LENGTH));
        } else {
            halfIndex = KYUFU_SEIGEN_LONG_NAME_LENGTH / 2;
            setter.setSeigenLong1(kyufuSeigenName.substring(0, halfIndex));
            setter.setSeigenLong2(kyufuSeigenName.substring(halfIndex, KYUFU_SEIGEN_LONG_NAME_LENGTH));
        }
        setter.setSeigenSt(toWarekiString(kyufuRange.getFrom()));
        setter.setSeigenEd(toWarekiString(kyufuRange.getTo()));
    }

    private interface IKyufuSeigenSetter {

        void setSeigen1(RString seigen1);

        void setSeigen2(RString seigen2);

        void setSeigenLong1(RString seigenLong1);

        void setSeigenLong2(RString seigenLong2);

        void setSeigenSt(RString seigenSt);

        void setSeigenEd(RString seigenEd);

    }

    private IKyufuSeigenSetter createKyufuSeigenSetter1(final IHihokenshashoCommonEditData source) {
        return new IKyufuSeigenSetter() {
            @Override
            public void setSeigen1(RString seigen1) {
                source.setSeigen1(seigen1);
            }

            @Override
            public void setSeigen2(RString seigen2) {

                source.setSeigen2(seigen2);
            }

            @Override
            public void setSeigenLong1(RString seigenLong1) {

                source.setSeigenLong1(seigenLong1);
            }

            @Override
            public void setSeigenLong2(RString seigenLong2) {
                source.setSeigenLong2(seigenLong2);
            }

            @Override
            public void setSeigenSt(RString seigenSt) {
                source.setSeigenSt1(seigenSt);
            }

            @Override
            public void setSeigenEd(RString seigenEd) {

                source.setSeigenEd1(seigenEd);
            }
        };
    }

    private IKyufuSeigenSetter createKyufuSeigenSetter2(final IHihokenshashoCommonEditData source) {
        return new IKyufuSeigenSetter() {
            @Override
            public void setSeigen1(RString seigen1) {
                source.setSeigen3(seigen1);
            }

            @Override
            public void setSeigen2(RString seigen2) {

                source.setSeigen4(seigen2);
            }

            @Override
            public void setSeigenLong1(RString seigenLong1) {

                source.setSeigenLong3(seigenLong1);
            }

            @Override
            public void setSeigenLong2(RString seigenLong2) {
                source.setSeigenLong4(seigenLong2);
            }

            @Override
            public void setSeigenSt(RString seigenSt) {
                source.setSeigenSt2(seigenSt);
            }

            @Override
            public void setSeigenEd(RString seigenEd) {

                source.setSeigenEd2(seigenEd);
            }
        };
    }

    private IKyufuSeigenSetter createKyufuSeigenSetter3(final IHihokenshashoCommonEditData source) {
        return new IKyufuSeigenSetter() {
            @Override
            public void setSeigen1(RString seigen1) {
                source.setSeigen5(seigen1);
            }

            @Override
            public void setSeigen2(RString seigen2) {

                source.setSeigen6(seigen2);
            }

            @Override
            public void setSeigenLong1(RString seigenLong1) {

                source.setSeigenLong5(seigenLong1);
            }

            @Override
            public void setSeigenLong2(RString seigenLong2) {
                source.setSeigenLong6(seigenLong2);
            }

            @Override
            public void setSeigenSt(RString seigenSt) {
                source.setSeigenSt3(seigenSt);
            }

            @Override
            public void setSeigenEd(RString seigenEd) {

                source.setSeigenEd3(seigenEd);
            }
        };
    }

    /**
     * 被保険者証帳票ソースに、居宅介護支援事業者の情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set居宅介護支援事業者(IHihokenshashoCommonEditData source) {

        List<RString> kyotakuShienJigyoshaNames = hihokenshashoModel.getShikakuHakko().get支援事業者名称();
        List<FlexibleDate> DateOfoutputTargets = setKyotakuDatesOfOutputTarget(hihokenshashoModel);

        for (int i = 0; i < 3 && i < kyotakuShienJigyoshaNames.size(); i++) {
            RString kyotakuJigyoshaName = kyotakuShienJigyoshaNames.get(i);
            RString DateOfoutputTargetString = toWarekiString(DateOfoutputTargets.get(i));

            switch (i) {
                case 0:
                    setKyotakuJigyosha1(kyotakuJigyoshaName, source, DateOfoutputTargetString);
                    break;
                case 1:
                    setKyotakuJigyosha2(kyotakuJigyoshaName, source, DateOfoutputTargetString);
                    break;
                default:
                    setKyotakuJigyosha3(kyotakuJigyoshaName, source, DateOfoutputTargetString);
                    break;
            }
        }
    }

    private void setKyotakuJigyosha1(RString kyotakuJigyoshaName, IHihokenshashoCommonEditData source, RString DateOfoutputTargetString) {
        if (is居宅支援事業者名の文字数がKYOTAKU_JIGYOSHA_NAME_STANDARD以下(kyotakuJigyoshaName)) {
            source.setGyosha1(kyotakuJigyoshaName);
        } else {
            source.setItakuGyosha1(kyotakuJigyoshaName);
        }
        source.setTodokeYmd1(DateOfoutputTargetString);
    }

    private void setKyotakuJigyosha2(RString kyotakuJigyoshaName, IHihokenshashoCommonEditData source, RString DateOfoutputTargetString) {
        if (is居宅支援事業者名の文字数がKYOTAKU_JIGYOSHA_NAME_STANDARD以下(kyotakuJigyoshaName)) {
            setKyotakuPrintJoho(craeteKyotakuGyoshaSetter2(source), kyotakuJigyoshaName);
        } else {
            setKyotakuPrintJoho(craeteKyotakuItakuGyoshaSetter2(source), kyotakuJigyoshaName);
        }
        setKyotakuPrintJoho(craeteKyotakuTodokeYmdSetter2(source), DateOfoutputTargetString);
    }

    private void setKyotakuJigyosha3(RString kyotakuJigyoshaName, IHihokenshashoCommonEditData source, RString DateOfoutputTargetString) {
        if (is居宅支援事業者名の文字数がKYOTAKU_JIGYOSHA_NAME_STANDARD以下(kyotakuJigyoshaName)) {
            setKyotakuPrintJoho(craeteKyotakuGyoshaSetter3(source), kyotakuJigyoshaName);
        } else {
            setKyotakuPrintJoho(craeteKyotakuItakuGyoshaSetter3(source), kyotakuJigyoshaName);
        }
        setKyotakuPrintJoho(craeteKyotakuTodokeYmdSetter3(source), DateOfoutputTargetString);
    }

    private boolean is居宅支援事業者名の文字数がKYOTAKU_JIGYOSHA_NAME_STANDARD以下(RString kyotakuJigyoshaName) {
        return kyotakuJigyoshaName.length() <= KYOTAKU_JIGYOSHA_NAME_STANDARD;
    }

    private List<FlexibleDate> setKyotakuDatesOfOutputTarget(HihokenshashoModel hihokenshashoModel) {
        if (printConfig.is届出日の代わりに適用開始日を表示()) {
            return hihokenshashoModel.getShikakuHakko().get支援事業者適用開始日();
        }
        return hihokenshashoModel.getShikakuHakko().get支援事業者届出日();
    }

    private void setKyotakuPrintJoho(IKyotakuShienJigyoshaSetter setter, RString printData) {
        switch (printConfig.get居宅支援事業者履歴表示方法()) {
            case 表示:
                setter.setTarget(printData);
                break;
            case アスタリスク:
                setter.setTarget(printData);
                RString asa = new RString("");
                setter.setTargetAsa(createAstelisk(printData.length() * 2));
                break;
            case 抹消線:
                setter.setTargetMassho(printData);
                break;
            default:
                break;
        }
    }

    private RString createAstelisk(int length) {
        RString asa = new RString("*");
        RStringBuilder asas = new RStringBuilder();
        for (int i = 0; i < length; i++) {
            asas.append(asa);
        }
        return asas.toRString();
    }

    private interface IKyotakuShienJigyoshaSetter {

        void setTarget(RString target);

        void setTargetAsa(RString targetAsa);

        void setTargetMassho(RString targetMassho);
    }

    private IKyotakuShienJigyoshaSetter craeteKyotakuGyoshaSetter2(final IHihokenshashoCommonEditData source) {
        return new IKyotakuShienJigyoshaSetter() {

            @Override
            public void setTarget(RString gyosha) {
                source.setGyosha2(gyosha);
            }

            @Override
            public void setTargetAsa(RString gyoshaAsa) {
                source.setGyosha2Asa(gyoshaAsa);
            }

            @Override
            public void setTargetMassho(RString gyoshaMassho) {
                source.setGyosha2Massho(gyoshaMassho);
            }
        };
    }

    private IKyotakuShienJigyoshaSetter craeteKyotakuItakuGyoshaSetter2(final IHihokenshashoCommonEditData source) {
        return new IKyotakuShienJigyoshaSetter() {

            @Override
            public void setTarget(RString itakuGyosha) {
                source.setItakuGyosha2(itakuGyosha);
            }

            @Override
            public void setTargetAsa(RString itakuGyoshaAsa) {
                source.setItakuGyosha2Asa(itakuGyoshaAsa);
            }

            @Override
            public void setTargetMassho(RString itakuGyoshaMassho) {
                source.setItakuGyosha2Massho(itakuGyoshaMassho);
            }
        };
    }

    private IKyotakuShienJigyoshaSetter craeteKyotakuTodokeYmdSetter2(final IHihokenshashoCommonEditData source) {
        return new IKyotakuShienJigyoshaSetter() {

            @Override
            public void setTarget(RString todokeYmdStr) {
                source.setTodokeYmd2(todokeYmdStr);
            }

            @Override
            public void setTargetAsa(RString todokeYmdAsaStr) {
                source.setTodokeYmd2Asa(todokeYmdAsaStr);
            }

            @Override
            public void setTargetMassho(RString todokeYmdMasshoStr) {
                source.setTodokeYmd2Massho(todokeYmdMasshoStr);
            }
        };
    }

    private IKyotakuShienJigyoshaSetter craeteKyotakuGyoshaSetter3(final IHihokenshashoCommonEditData source) {
        return new IKyotakuShienJigyoshaSetter() {

            @Override
            public void setTarget(RString gyosha) {
                source.setGyosha3(gyosha);
            }

            @Override
            public void setTargetAsa(RString gyoshaAsa) {
                source.setGyosha3Asa(gyoshaAsa);
            }

            @Override
            public void setTargetMassho(RString gyoshaMassho) {
                source.setGyosha3Massho(gyoshaMassho);
            }
        };
    }

    private IKyotakuShienJigyoshaSetter craeteKyotakuItakuGyoshaSetter3(final IHihokenshashoCommonEditData source) {
        return new IKyotakuShienJigyoshaSetter() {

            @Override
            public void setTarget(RString itakuGyosha) {
                source.setItakuGyosha3(itakuGyosha);
            }

            @Override
            public void setTargetAsa(RString itakuGyoshaAsa) {
                source.setItakuGyosha3Asa(itakuGyoshaAsa);
            }

            @Override
            public void setTargetMassho(RString itakuGyoshaMassho) {
                source.setItakuGyosha3Massho(itakuGyoshaMassho);
            }
        };
    }

    private IKyotakuShienJigyoshaSetter craeteKyotakuTodokeYmdSetter3(final IHihokenshashoCommonEditData source) {
        return new IKyotakuShienJigyoshaSetter() {

            @Override
            public void setTarget(RString todokeYmdStr) {
                source.setTodokeYmd3(todokeYmdStr);
            }

            @Override
            public void setTargetAsa(RString todokeYmdAsaStr) {
                source.setTodokeYmd3Asa(todokeYmdAsaStr);
            }

            @Override
            public void setTargetMassho(RString todokeYmdMasshoStr) {
                source.setTodokeYmd3Massho(todokeYmdMasshoStr);
            }
        };
    }

    /**
     * 被保険者証帳票ソースに、介護保険施設等などの情報を設定します。
     *
     * @param source 被保険者証帳票ソース
     */
    public void set介護保険施設等(IHihokenshashoCommonEditData source) {

        List<RString> nyushoShisetsuCodes = hihokenshashoModel.getShikakuHakko().get入所施設コード();
        List<RString> nyushoShisetsuNames = hihokenshashoModel.getShikakuHakko().get施設名();
        List<FlexibleDate> nyushoDates = hihokenshashoModel.getShikakuHakko().get施設入所日();
        List<FlexibleDate> taishoDates = hihokenshashoModel.getShikakuHakko().get施設退所日();

        for (int i = 0; i < 2 && i < nyushoShisetsuCodes.size(); i++) {
            INyushoShisetsuSetter setter;
            switch (i) {
                case 0:
                    setter = createNyushoShisetsuSetter1(source);
                    break;
                default:
                    setter = createNyushoShisetsuSetter2(source);
                    break;
            }
            RString nyushoShisetsuCode = nyushoShisetsuCodes.get(i);
            RString nyushoShisetsuName = nyushoShisetsuNames.get(i);
            FlexibleDate nyushoDate = nyushoDates.get(i);
            FlexibleDate taishoDate = taishoDates.get(i);
            setNyutaishoData(setter, IryoKikanAndJigyoshaKubun.toValue(nyushoShisetsuCode).getName(), nyushoShisetsuName, nyushoDate, taishoDate);
            setNyutaishoAsterisk(setter, nyushoShisetsuCode);
        }
    }

    private void setNyutaishoData(INyushoShisetsuSetter setter,
            RString shisetsuSyu, RString shisetsuName, FlexibleDate nyushoYmd, FlexibleDate taishoYmd) {
        setter.setShisetsuSyu(shisetsuSyu);
        setter.setShisetsuname(shisetsuName);
        setter.setNyushoymd(toWarekiString(nyushoYmd));
        setter.setTaishoymd(toWarekiString(taishoYmd));
    }

    private void setNyutaishoAsterisk(INyushoShisetsuSetter setter, RString jigyoshaNo) {
        if (IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo).is医療機関()) {
            setter.setNyushochk();
            setter.setTaishochk();
        } else {
            setter.setNyuinchk();
            setter.setTaiinchk();
        }
    }

    private interface INyushoShisetsuSetter {

        void setShisetsuSyu(RString shisetsuShurui);

        void setShisetsuname(RString shisetsuName);

        void setNyushoymd(RString nyushoYmdStr);

        void setTaishoymd(RString taishoYmdStr);

        void setNyushochk();

        void setTaishochk();

        void setNyuinchk();

        void setTaiinchk();
    }

    private INyushoShisetsuSetter createNyushoShisetsuSetter1(final IHihokenshashoCommonEditData source) {
        return new INyushoShisetsuSetter() {

            @Override
            public void setShisetsuSyu(RString shisetsuShurui) {
                source.setShisetsuSyu1(shisetsuShurui);
            }

            @Override
            public void setShisetsuname(RString shisetsuName) {
                source.setShisetsuname1(shisetsuName);
            }

            @Override
            public void setNyushoymd(RString nyushoYmdStr) {
                source.setNyushoymd1(nyushoYmdStr);
            }

            @Override
            public void setTaishoymd(RString taishoYmdStr) {
                source.setTaiinymd1(taishoYmdStr);
            }

            @Override
            public void setNyushochk() {
                source.setNyushochk1(DAUB_WORD);
            }

            @Override
            public void setTaishochk() {
                source.setTaishochk1(DAUB_WORD);
            }

            @Override
            public void setNyuinchk() {
                source.setNyuinchk1(DAUB_WORD);
            }

            @Override
            public void setTaiinchk() {
                source.setTaiinchk1(DAUB_WORD);
            }

        };
    }

    private INyushoShisetsuSetter createNyushoShisetsuSetter2(final IHihokenshashoCommonEditData source) {
        return new INyushoShisetsuSetter() {

            @Override
            public void setShisetsuSyu(RString shisetsuShurui) {
                source.setShisetsuSyu2(shisetsuShurui);
            }

            @Override
            public void setShisetsuname(RString shisetsuName) {
                source.setShisetsuname2(shisetsuName);
            }

            @Override
            public void setNyushoymd(RString nyushoYmdStr) {
                source.setNyushoymd2(nyushoYmdStr);
            }

            @Override
            public void setTaishoymd(RString taishoYmdStr) {
                source.setTaiinymd2(taishoYmdStr);
            }

            @Override
            public void setNyushochk() {
                source.setNyushochk2(DAUB_WORD);
            }

            @Override
            public void setTaishochk() {
                source.setTaishochk2(DAUB_WORD);
            }

            @Override
            public void setNyuinchk() {
                source.setNyuinchk2(DAUB_WORD);
            }

            @Override
            public void setTaiinchk() {
                source.setTaiinchk2(DAUB_WORD);
            }

        };
    }

    private static RString toWarekiString(RDate date) {
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private static RString toWarekiString(FlexibleDate date) {
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}

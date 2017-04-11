/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.commonchilddiv.seikatsuhogojoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.seikatsuhogojoho.SeikatsuFujyoShubetsuJoho;
import jp.co.ndensan.reams.db.dba.business.core.seikatsuhogojoho.SeikatsuTeishiJoho;
import jp.co.ndensan.reams.db.dba.business.core.seikatsuhogojoho.SeikatsuTorokuJoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoCommonDiv.SeikatsuHogoJohoCommonDivDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoCommonDiv.dgRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dba.service.core.seikatsuhogojoho.SeikatsuHogoJohoTorukuManager;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.KaigoRyoDairiNofuKubun;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.KyugoShisetsuNyuTaishoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 * @author n8407
 */
public class SeikatsuHogoJohoHandler {

    private final SeikatsuHogoJohoCommonDivDiv div;
    private static final RString SLASH = new RString("/");
    private static final RString TILDE = new RString("~");

    /**
     * コンストラクタです。
     *
     * @param div 活保護情報ダイアログDiv
     */
    public SeikatsuHogoJohoHandler(SeikatsuHogoJohoCommonDivDiv div) {

        this.div = div;
    }

    /**
     * 生活保護情報ダイアログの初期化します。
     *
     *
     */
    public void load() {
        SeikatsuHogoJohoTorukuManager manager = SeikatsuHogoJohoTorukuManager.createInstance();
        RString shikibetsuCode = div.getShikibetsuCode();
        RString gyomuCode = div.getGyomuCode();
        div.getDgRirekiIchiran().init();

        List<SeikatsuTorokuJoho> johos = manager.get生活保護情報登録リスト(shikibetsuCode, gyomuCode);
        if (johos != null && !johos.isEmpty()) {
            List<dgRirekiIchiran_Row> rows = new ArrayList<>();
            for (SeikatsuTorokuJoho toroku : johos) {
                dgRirekiIchiran_Row row = new dgRirekiIchiran_Row();
                if (toroku.get生活保護受給者().get受給廃止日() != null) {
                    row.setJukyuHaishiYMD(toroku.get生活保護受給者().get受給廃止日().wareki().toDateString());

                } else {
                    row.setJukyuHaishiYMD(RString.EMPTY);
                }
                if (toroku.get生活保護受給者().get介護保険料代理納付年月() != null) {
                    row.setKaigoRyoDairiNofuYM(toroku.get生活保護受給者().get介護保険料代理納付年月().wareki().firstYear(FirstYear.ICHI_NEN)
                            .toDateString());
                } else {
                    row.setKaigoRyoDairiNofuYM(RString.EMPTY);
                }
                if (toroku.get生活保護受給者().get救護施設入退所日() != null) {
                    row.setKyugoShisetsuNyutaishoYMD(toroku.get生活保護受給者().get救護施設入退所日().wareki().toDateString());
                } else {
                    row.setKyugoShisetsuNyutaishoYMD(RString.EMPTY);
                }
                row.setJukyushaNo(toroku.get生活保護受給者().get受給者番号());
                row.setJukyuKaishiYMD(toroku.get生活保護受給者().get受給開始日().wareki().toDateString());
                row.setKaigoRyoDairiNofuKubun(new KaigoRyoDairiNofuKubun(toroku.get生活保護受給者().get介護保険料代理納付区分()).value().toRString());
                row.setKyugoShisetsuNyuTaishoKubun(new KyugoShisetsuNyuTaishoKubun(toroku.get生活保護受給者().get救護施設入退所区分())
                        .value().toRString());
                row.setKyugoShisetsuNyutaishoYMD(toroku.get生活保護受給者().get救護施設入退所日().wareki().toDateString());
                RStringBuilder builder = new RStringBuilder();
                if (!toroku.get停止期間リスト().isEmpty()) {
                    for (SeikatsuTeishiJoho joho : toroku.get停止期間リスト()) {
                        teishikikanGapeiShori(joho, builder);
                    }
                    builder.deleteCharAt(builder.length() - 1);
                }
                RStringBuilder fujyoryakusho = new RStringBuilder();
                RStringBuilder fujyorCode = new RStringBuilder();
                if (!toroku.get扶助種別リスト().isEmpty()) {
                    for (SeikatsuFujyoShubetsuJoho joho : toroku.get扶助種別リスト()) {
                        fujyoryakusho.append(joho.get扶助種別コード().getRyakusho())
                                .append(SLASH);
                        fujyorCode.append(joho.get扶助種別コード().getColumnValue().value())
                                .append(SLASH);
                    }
                    fujyoryakusho.deleteCharAt(fujyoryakusho.length() - 1);
                    fujyorCode.deleteCharAt(fujyorCode.length() - 1);
                }
                row.setJukyuTeishiKikan(builder.toRString());
                row.setFujoShurui(fujyoryakusho.toRString());
                row.setFujoShuruiCode(fujyorCode.toRString());
                rows.add(row);
            }
            
            div.getDgRirekiIchiran().setDataSource(rows);
        }

    }

    private void teishikikanGapeiShori(SeikatsuTeishiJoho joho, RStringBuilder builder) {
        if (joho.get受給停止終了日() != null
                && joho.get受給停止開始日() != null) {
            builder.append(joho.get受給停止開始日().wareki().toDateString())
                    .append(TILDE)
                    .append(joho.get受給停止終了日().wareki().toDateString())
                    .append(SLASH);
        }
        if (joho.get受給停止開始日() != null && joho.get受給停止終了日() == null) {
            builder.append(joho.get受給停止開始日().wareki().toDateString())
                    .append(TILDE)
                    .append(RString.EMPTY)
                    .append(SLASH);
        }
    }

}

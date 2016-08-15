package jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 根拠CSV_一般状況_1_to_11を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 wangchao
 */
public enum KonkyoCsv_IppanJokyo_1_to_11 {

    /**
     * コード:DBZ010100 名称:別紙(1) 第１号被保険者のいる世帯 略称:定義なし
     */
    別紙_1_第１号被保険者のいる世帯("DBZ010100", "別紙(1) 第１号被保険者のいる世帯"),
    /**
     * コード:DBZ010200 名称:第１号被保険者数 略称:定義なし
     */
    第１号被保険者数("DBZ010200", "第１号被保険者数"),
    /**
     * コード:DBZ010301 名称:第１号被保険者増減内訳_当月中増 略称:定義なし
     */
    第１号被保険者増減内訳_当月中増("DBZ010301", "第１号被保険者増減内訳_当月中増"),
    /**
     * コード:DBZ010302 名称:第１号被保険者増減内訳_当月中減 略称:定義なし
     */
    第１号被保険者増減内訳_当月中減("DBZ010302", "第１号被保険者増減内訳_当月中減"),
    /**
     * コード:DBZ010600 名称:利用者負担減額・免除認定（総数） 略称:定義なし
     */
    利用者負担減額_免除認定_総数("DBZ010600", "利用者負担減額・免除認定（総数）"),
    /**
     * コード:DBZ010702 名称:介護老人福祉施設旧措置入所者に係る減額・減免認定（総数） 略称:定義なし
     */
    介護老人福祉施設旧措置入所者に係る減額_減免認定_総数_DBZ010702("DBZ010702", "介護老人福祉施設旧措置入所者に係る減額・減免認定（総数）"),
    /**
     * コード:DBZ010710 名称:食費・居住費に係る負担限度額認定（総数） 略称:定義なし
     */
    食費_居住費に係る負担限度額認定_総数("DBZ010710", "食費・居住費に係る負担限度額認定（総数）"),
    /**
     * コード:DBZ010720 名称:介護老人福祉施設旧措置入所者に係る減額・減免認定（総数） 略称:定義なし
     */
    介護老人福祉施設旧措置入所者に係る減額_減免認定_総数_DBZ010720("DBZ010720", "介護老人福祉施設旧措置入所者に係る減額・減免認定（総数）"),
    /**
     * コード:DBZ010900 名称:利用者負担減額・免除認定（再掲：第２号被保険者分） 略称:定義なし
     */
    利用者負担減額_免除認定_再掲_第２号被保険者分("DBZ010900", "利用者負担減額・免除認定（再掲：第２号被保険者分）"),
    /**
     * コード:DBZ011002 名称:介護老人福祉施設旧措置入所者に係る減額・免除認定（再掲：第２号被保険者分） 略称:定義なし
     */
    介護老人福祉施設旧措置入所者に係る減額_免除認定_再掲_第２号被保険者分_DBZ011002("DBZ011002",
            "介護老人福祉施設旧措置入所者に係る減額・免除認定（再掲：第２号被保険者分）"),
    /**
     * コード:DBZ011010 名称:食費・居住費に係る負担限度額認定（再掲：第２号被保険者分） 略称:定義なし
     */
    食費_居住費に係る負担限度額認定_再掲_第２号被保険者分("DBZ011010", "食費・居住費に係る負担限度額認定（再掲：第２号被保険者分）"),
    /**
     * コード:DBZ011020 名称:介護老人福祉施設旧措置入所者に係る減額・免除認定（再掲：第２号被保険者分） 略称:定義なし
     */
    介護老人福祉施設旧措置入所者に係る減額_免除認定_再掲_第２号被保険者分_DBZ011020("DBZ011020",
            "介護老人福祉施設旧措置入所者に係る減額・免除認定（再掲：第２号被保険者分）"),
    /**
     * コード:DBZ011030 名称:利用者負担第４段階における食費・居住費の特例減額措置 略称:定義なし
     */
    利用者負担第４段階における食費_居住費の特例減額措置("DBZ011030", "利用者負担第４段階における食費・居住費の特例減額措置"),
    /**
     * コード:DBZ011040 名称:食費・居住費に係る負担限度額認定（再掲：税制改正による激変緩和措置を受けている者） 略称:定義なし
     */
    食費_居住費に係る負担限度額認定_再掲_税制改正による激変緩和措置を受けている者("DBZ011040",
            "食費・居住費に係る負担限度額認定（再掲：税制改正による激変緩和措置を受けている者）"),
    /**
     * コード:DBZ011100 名称:要介護（要支援）認定者数 略称:定義なし
     */
    要介護_要支援_認定者数("DBZ011100", "要介護（要支援）認定者数");

    private final RString code;
    private final RString fullName;

    private KonkyoCsv_IppanJokyo_1_to_11(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 根拠CSV_一般状況_1_to_11のコードを返します。
     *
     * @return 根拠CSV_一般状況_1_to_11のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 根拠CSV_一般状況_1_to_11の名称を返します。
     *
     * @return 根拠CSV_一般状況_1_to_11の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 根拠CSV_一般状況_1_to_11のコードと一致する内容を探します。
     *
     * @param code 根拠CSV_一般状況_1_to_11のコード
     * @return {@code code} に対応する根拠CSV_一般状況_1_to_11
     */
    public static KonkyoCsv_IppanJokyo_1_to_11 toValue(RString code) {
        for (KonkyoCsv_IppanJokyo_1_to_11 konkyoCsv_IppanJokyo_1_to_11 : KonkyoCsv_IppanJokyo_1_to_11.values()) {
            if (konkyoCsv_IppanJokyo_1_to_11.code.equals(code)) {
                return konkyoCsv_IppanJokyo_1_to_11;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("根拠CSV_一般状況_1_to_11"));
    }
}
